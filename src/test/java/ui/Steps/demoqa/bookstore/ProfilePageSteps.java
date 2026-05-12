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
    }

    @Step("Переход в магазин книг")
    public void goToBookStore(){
        profilePage.goToBooksStore();
    }

    @Step("Добавление всех книг в профиль")
    public void addAllBooks(){
        profilePage.addAllBooksToProfile();
    }

    @Step("Проверка всех книг в профиль")
    public void checkAllBooksInProfile(){
        profilePage.checkAllAddedBooksInProfile();
    }

    @Step("Поиск книги по имени")
    public void findBookInProfile(String book){
        profilePage.searchBook(book);
    }

    @Step("Удаление одной книги")
    public void deleteOneBook(){
        profilePage.deleteFirstBook();
    }

    @Step("Удаление всех книг")
    public void deleteAllBooksInProfile(){
        profilePage.deleteAllBooks();
    }

    @Step("Выход из аккаунта")
    public void logout(){
        profilePage.logOut();
    }

    @Step("Создание нового аккаунта")
    public void registerNewAccount(String first, String last, String login, String password){
        profilePage.registerNewUser(first, last, login, password);
    }

}
