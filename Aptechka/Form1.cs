using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Aptechka
{
    public partial class Form1 : Form
    {
        private SqlConnection connection;
        public Form1()
        {
            InitializeComponent();
            ConnectToDatabase();
            LoadMedicinesToDataGridView();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
        private void ConnectToDatabase()
        {
            string connectionString = "Data Source=(localdb)\\MSSQLLocalDb;Initial Catalog=Pharmacy;Integrated Security=True"; // Укажите ваш сервер
            connection = new SqlConnection(connectionString);
            connection.Open();
         }
        private void LoadMedicinesToDataGridView()
        {
            var medicines = LoadMedicinesFromDatabase();

            // Очищаем DataGridView перед добавлением новых данных
            dataGridView1.Rows.Clear();
            dataGridView1.Columns.Clear();

            // Добавляем заголовки для категорий
            string[] categories = new string[]
            {
                "Антибактериальные препараты",
                "Гормоны",
                "Диагностические средства",
                "Препараты, влияющие на иммунитет",
                "Препараты, влияющие на метаболизм",
                "Препараты, влияющие на психику",
                "Препараты, влияющие на свертываемость крови",
                "Препараты, влияющие на тонус сосудов",
                "Препараты, влияющие на функцию бронхов",
                "Препараты, влияющие на функции желудочно-кишечного тракта",
                "Препараты, влияющие на функции миокарда",
                "Препараты, влияющие на функцию почек",
                "Противовирусные препараты",
                "Противовоспалительные и обезболивающие препараты",
                "Противогрибковые препараты",
                "Противоопухолевые препараты",
                "Противопаразитарные и противоглистные препараты"
            };

            // Добавляем 17 колонок с названиями категорий
            for (int i = 0; i < categories.Length; i++)
            {
                dataGridView1.Columns.Add("Category" + (i + 1), categories[i]);
            }

                // Устанавливаем ширину заголовка строк
                dataGridView1.RowHeadersWidth = 80;

                // Устанавливаем высоту строк
                dataGridView1.RowTemplate.Height = 50; // Установите желаемую высоту
            
                // Группируем лекарства по полкам
                var groupedMedicines = medicines.GroupBy(m => m.Location);

            // Добавляем строки для каждой полки
            foreach (var group in groupedMedicines)
            {
                // Добавляем новую строку для текущей полки
                int rowIndex = dataGridView1.Rows.Add(); // Добавляем новую строку
                dataGridView1.Rows[rowIndex].HeaderCell.Value = group.Key; // Устанавливаем название полки

                // Заполняем ячейки названиями препаратов по категориям для текущей полки
                foreach (var medicine in group)
                {
                    // Находим индекс категории
                    int categoryIndex = Array.IndexOf(categories, medicine.Category);
                    if (categoryIndex >= 0)
                    {
                        // Устанавливаем название препарата в соответствующую ячейку
                        dataGridView1.Rows[rowIndex].Cells[categoryIndex].Value = medicine.Name;
                    }
                }
            }

            // Сортировка по названию полки
            //dataGridView1.Sort(dataGridView1.Columns[0], System.ComponentModel.ListSortDirection.Ascending);
        }


        private List<Medicine> LoadMedicinesFromDatabase()
        {
            List<Medicine> medicines = new List<Medicine>();

            string query = "SELECT Name, Category, Form, Location FROM Pharmacy"; // Убедитесь, что здесь правильное имя таблицы
            SqlCommand command = new SqlCommand(query, connection);

            using (SqlDataReader reader = command.ExecuteReader())
            {
                if (reader.HasRows) // Проверяем, есть ли строки
                {
                    while (reader.Read())
                    {
                        medicines.Add(new Medicine
                        {
                            Name = reader["Name"].ToString(),
                            Category = reader["Category"].ToString(),
                            Form = reader["Form"].ToString(),
                            Location = reader["Location"].ToString() // Сохраняем название полки
                        });
                    }
                }
                else
                {
                    MessageBox.Show("Нет данных в таблице Pharmacy."); // Уведомление, если данных нет
                }
            }

            return medicines;
        }

        private void button1_Click(object sender, EventArgs e)
        {

            string searchTerm = textBox1.Text.ToLower();

            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                if (row.Cells[0].Value != null && row.Cells[0].Value.ToString().ToLower().Contains(searchTerm))
                {
                    row.Selected = true; // Подсвечиваем найденную строку
                    row.DefaultCellStyle.BackColor = Color.Yellow; // Меняем цвет фона
                }
                else
                {
                    row.Selected = false; // Убираем выделение, если не найдено
                    row.DefaultCellStyle.BackColor = Color.White; // Возвращаем цвет фона
                }
            }
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (connection != null && connection.State == ConnectionState.Open)
            {
                connection.Close();
            }
        }
        public class Medicine
        {
            public string Name { get; set; }
            public string Category { get; set; }
            public string Form { get; set; }
            public string Location { get; set; }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            string searchText = textBox1.Text.ToLower();

            // Сбрасываем цвет ячеек перед новым поиском
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                foreach (DataGridViewCell cell in row.Cells)
                {
                    cell.Style.BackColor = Color.White; // Устанавливаем белый цвет для всех ячеек
                }
            }

            // Если текст для поиска не пустой
            if (!string.IsNullOrEmpty(searchText))
            {
                // Проходим по всем строкам и ячейкам
                foreach (DataGridViewRow row in dataGridView1.Rows)
                {
                    foreach (DataGridViewCell cell in row.Cells)
                    {
                        // Проверяем, содержит ли ячейка текст для поиска
                        if (cell.Value != null && cell.Value.ToString().ToLower().Contains(searchText))
                        {
                            // Выделяем ячейку цветом
                            cell.Style.BackColor = Color.Yellow; // Вы можете выбрать любой другой цвет
                        }
                    }
                }
            }
        }
    }
}
