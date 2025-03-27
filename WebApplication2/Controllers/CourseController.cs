using Microsoft.AspNetCore.Mvc;
using WebApplication2.Models;

namespace WebApplication2.Controllers
{
    public class CourseController : Controller
    {
        private static List<Course> courses = new List<Course>();
        private static int courseIdCounter = 1; // Для уникального ID

        public IActionResult Index()
        {
            return View(courses);
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Course course)
        {
            course.Id = courseIdCounter++;
            courses.Add(course);
            return RedirectToAction("Index");
        }
    }
}
