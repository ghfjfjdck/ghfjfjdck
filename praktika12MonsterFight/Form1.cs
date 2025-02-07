using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using prakt11;

namespace praktika12MonsterFight
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        Monster Hero = new Monster();
        Monster monster2 = new Monster();
        private void Form1_Load(object sender, EventArgs e)
        {
            Random rnd = new Random();
            string[] s = new string[6] { @"png\m2.jpg", @"png\m3.jpg", @"png\m4.jpg", @"png\m5.jpg", @"png\m6.jpg", @"png\m7.jpg"};
            groupBox1.Visible = false;
            monster2.CreatMonster();
            monster2.SetHP();
            monster2.Setdamage();
            label2.Text = monster2.Getname();
            label3.Text = Convert.ToString(monster2.GetHP());
            label4.Text = Convert.ToString(monster2.Getdamage());
            progressBar1.Value = monster2.GetHP();
            pictureBox2.ImageLocation = s[rnd.Next(6)];
        }
        
        private void button1_Click(object sender, EventArgs e)
        {
            Hero.SetHP();
            Hero.Setdamage();
            int a = comboBox1.SelectedIndex;
            int b = comboBox2.SelectedIndex;
            if (a == 0)
                Hero.FinishHP(3);
            if(a==1)
                Hero.FinishHP(5);
            if(a==2)
                Hero.FinishHP(2);
            if (b== 0)
                Hero.FinishDMG(5);
            if (b == 1)
                Hero.FinishDMG(6);
            if (b == 2)
                Hero.FinishDMG(1); 
            Hero.NameHero(textBox1.Text);
            groupBox1.Visible = true;
            label7.Text = Hero.Getname();
            label6.Text = Convert.ToString(Hero.GetHP());
            label5.Text = Convert.ToString(Hero.Getdamage());
            progressBar2.Value = Hero.GetHP();
            button3.Visible = true;
            groupBox2.Enabled = false;

        }

        private void button3_Click(object sender, EventArgs e)
        {
            string b = "";
            string s = "";
            Hero.Winner(out b, monster2);
            monster2.Winner(out b, Hero);
            if (b != "")
                MessageBox.Show(b);
            Hero.Fight(out s,Convert.ToInt32(monster2.Getdamage()),monster2);
            label6.Text = Convert.ToString(Hero.GetHP());
            if (Hero.GetHP() <= 0)
            {
                progressBar2.Value = 0;
            }else
            progressBar2.Value = Hero.GetHP();
            if (s!="")
            MessageBox.Show(s);
            monster2.Fight(out s, Convert.ToInt32(Hero.Getdamage()),Hero);
            label3.Text = Convert.ToString(monster2.GetHP());
            if (monster2.GetHP() <= 0)
            {
                progressBar1.Value = 0;
            }
            else
            progressBar1.Value = monster2.GetHP();
            if (s!="")
            MessageBox.Show(s);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }
    }
}
