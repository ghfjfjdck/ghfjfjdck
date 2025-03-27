using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models;
using System.Collections.Generic;

namespace WebApplication2.Controllers
{
    public class StudentController : Controller
    {
        // Статический список для хранения студентов
        private static List<Student> students = new List<Student>();

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Student student)
        {
            if (ModelState.IsValid)
            {
                students.Add(student); // Добавляем студента в список
                TempData["Notification"] = "Студент успешно добавлен!"; // Уведомление
                return RedirectToAction("Index"); // Перенаправление на страницу списка студентов
            }
            return View(student);
        }

        public IActionResult Index()
        {
            return View(students); // Передаем список студентов в представление
        }
    }
}
