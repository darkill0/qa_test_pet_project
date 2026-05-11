package ui.demoqatests.interactions;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ui.Steps.demoqa.interactions.DroppableSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("DemoQA Тестирование")
@Feature("Взаимодействия - Droppable")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("droppable_page_ui_tests")
public class DroppableTests {

    private DroppableSteps droppableSteps;

    @BeforeEach
    @Description("Настройка: открыть страницу Droppable перед каждым тестом")
    public void setUp() {
        droppableSteps = new DroppableSteps();
        droppableSteps.openDroppablePage();
    }

    @Test
    @Order(1)
    @Tag("smoke")
    @Tag("droppable")
    @DisplayName("Простое перетаскивание должно работать корректно")
    @Description("Проверить, что перетаскивание элемента в зону дропа меняет текст на 'Dropped!'")
    @Story("Простой Droppable")
    public void testSimpleDragAndDrop() {
        // Сначала проверяем, что мы на правильной вкладке и видим элементы
        droppableSteps
                .goToSimpleTab();

        // Проверяем, что элементы видны
        droppableSteps.droppablePage.getDraggableSimple().scrollTo();
        droppableSteps.droppablePage.getDraggableSimple().isDisplayed();
        droppableSteps.droppablePage.getDroppableSimple().isDisplayed();

        // Выводим начальный текст для отладки
        String initialText = droppableSteps.droppablePage.getDropResultText();
        System.out.println("Initial text: '" + initialText + "'");

        // Пробуем разные способы перетаскивания
        // Способ 1: с задержкой


        // Способ 2: если не сработало, пробуем стандартный
        // droppableSteps.dragAndDrop(
        //     droppableSteps.droppablePage.getDraggableSimple(),
        //     droppableSteps.droppablePage.getDroppableSimple()
        // );

        // Проверяем результат
        String afterDropText = droppableSteps.droppablePage.getDropResultText();
        System.out.println("After drop text: '" + afterDropText + "'");

        droppableSteps
                .verifyDropSuccessful()
                .verifyDroppableHighlighted(droppableSteps.droppablePage.getDroppableSimple());
    }

    @Test
    @Tag("smoke")
    @Tag("droppable")
    @DisplayName("Допустимый элемент должен успешно дропаться")
    @Description("Проверить, что элемент 'Acceptable' может быть дропнут в зону")
    @Story("Accept Droppable")
    public void testAcceptableElementCanBeDropped() {
        droppableSteps
                .goToAcceptTab()
                .verifyAcceptableDroppable();
    }

    @Test
    @Order(3)
    @Tag("smoke")
    @Tag("droppable")
    @DisplayName("Возвращаемый элемент должен вернуться на исходную позицию")
    @Description("Проверить, что элемент 'Will Revert' возвращается на исходную позицию после дропа")
    @Story("Revertable Droppable")
    public void testWillRevertReturnsToOriginalPosition() {
        String initialPosition = droppableSteps.getInitialRevertablePosition();

        droppableSteps
                .goToRevertableTab()
                .dragAndDrop(
                        droppableSteps.droppablePage.getWillRevert(),
                        droppableSteps.droppablePage.getDroppableRevert()
                )
                .verifyDroppableHighlighted(droppableSteps.droppablePage.getDroppableRevert())
                .waitForRevertAnimation();

        String positionAfterRevert = droppableSteps.droppablePage.getDraggablePosition(
                droppableSteps.droppablePage.getWillRevert()
        );

        assertEquals(initialPosition, positionAfterRevert, "Элемент должен вернуться на исходную позицию");
    }
}