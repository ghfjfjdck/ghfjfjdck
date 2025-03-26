namespace WebApplication1
{
    public class MenuService
    {
        
            public List<string> GetMenu(User user)
            {
                List<string> menu = new List<string>();

                    string Request = user.Role.ToUpper();

                if (Request =="ADMIN")
                {
                    menu.Add("Управление пользователями");
                    menu.Add("Настройки системы");
                    menu.Add("Отчеты");
                }
                else if (Request == "USER")
                {
                    menu.Add("Мои задачи");
                    menu.Add("Профиль");
                    menu.Add("Помощь");
                }
                else if (Request == "GUEST")
                {
                    menu.Add("Вход");
                    menu.Add("Регистрация");
                    menu.Add("О нас");
                }
            else
            {
                menu.Add("Неизвестная роль");
            }
            return menu;
            }
        
    }
}
