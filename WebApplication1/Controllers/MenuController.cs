using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MenuController : ControllerBase
    {
        private readonly MenuService _menuService;

        public MenuController()
        {
            _menuService = new MenuService(); // Инициализация MenuService
        }

        [HttpGet("{role}")]
        public ActionResult<List<string>> GetMenu(string role)
        {
            User user = new User { Role = role };
            var menu = _menuService.GetMenu(user);
            return Ok(menu);
        }
    }
}
