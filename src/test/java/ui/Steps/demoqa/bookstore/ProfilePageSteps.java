package ui.Steps.demoqa.bookstore;

import io.qameta.allure.Step;
import ui.pages.demqa.bookstore.ProfilePage;

public class ProfilePageSteps {

    private final ProfilePage profilePage = new ProfilePage();

    @Step("Открытие страницы логина")
    public void openLoginPage(){
        profilePage.openUrlSite();
    }

    @Step("Вход в аккаунт")
    public void login(String login, String password){
        profilePage.login(login, password);
        System.out.println("Прошли логин");
    }

    @Step("Переход в магазин книг")
    public void goToBookStore(){
        profilePage.goToBooksStore();
        System.out.println("Перешли в магаз");
    }

    @Step("Добавление всех книг в профиль")
    public void addAllBooks(){
        profilePage.addAllBooksToProfile();
        System.out.println("Добавили книги");
    }

    @Step("Проверка всех книг в профиль")
    public void checkAllBooksInProfile(){
        profilePage.checkAllAddedBooksInProfile();
        System.out.println("Проверка книг в профиле");
    }

    @Step("Поиск книги по имени")
    public void findBookInProfile(String book){
        profilePage.searchBook(book);
        System.out.println("Нашли книгу");
    }

    @Step("Удаление одной книги")
    public void deleteOneBook(){
        profilePage.deleteFirstBook();
        System.out.println("Удалили книгу");
    }

    @Step("Удаление всех книг")
    public void deleteAllBooksInProfile(){
        profilePage.deleteAllBooks();
        System.out.println("Удалили все книги");
    }

    @Step("Выход из аккаунта")
    public void logout(){
        profilePage.logOut();
        System.out.println("Вышли из акка");
    }

    @Step("Создание нового аккаунта")
    public void registerNewAccount(String first, String last, String login, String password){
        profilePage.registerNewUser(first, last, login, password);
        System.out.println("Зарегали нового пользователя");
    }

}
