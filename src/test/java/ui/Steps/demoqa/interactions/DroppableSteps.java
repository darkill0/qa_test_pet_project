package ui.Steps.demoqa.interactions;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pages.demqa.interactions.DroppablePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DroppableSteps {
    public final DroppablePage droppablePage = new DroppablePage();

    @Step("Открыть страницу Droppable")
    public DroppableSteps openDroppablePage() {
        droppablePage.openPage();
        return this;
    }

    @Step("Перейти на вкладку Simple")
    public DroppableSteps goToSimpleTab() {
        droppablePage.clickSimpleTab();
        return this;
    }

    @Step("Перейти на вкладку Accept")
    public DroppableSteps goToAcceptTab() {
        droppablePage.clickAcceptTab();
        return this;
    }

    @Step("Перейти на вкладку Prevent Propagation")
    public DroppableSteps goToPreventPropagationTab() {
        droppablePage.clickPreventPropagationTab();
        return this;
    }

    @Step("Перейти на вкладку Revertable")
    public DroppableSteps goToRevertableTab() {
        droppablePage.clickRevertableTab();
        return this;
    }

    @Step("Перетащить элемент с помощью JavaScript (надежный способ)")
    public DroppableSteps dragAndDropWithJS(SelenideElement source, SelenideElement target) {
        droppablePage.dragAndDropWithJS(source, target);
        return this;
    }

    @Step("Перетащить элемент с помощью Selenide")
    public DroppableSteps dragAndDrop(SelenideElement source, SelenideElement target) {
        droppablePage.dragAndDropElement(source, target);
        return this;
    }

    @Step("Перетащить элемент с помощью Actions")
    public DroppableSteps performDragAndDrop(SelenideElement source, SelenideElement target) {
        droppablePage.performDragAndDrop(source, target);
        return this;
    }

    @Step("Проверить, что дроп выполнен успешно - текст изменился на 'Dropped!'")
    public DroppableSteps verifyDropSuccessful() {
        String dropText = droppablePage.getDropResultText();
        assertThat("Текст после дропа должен быть 'Dropped!'", dropText, equalTo("Dropped!"));
        return this;
    }

    @Step("Проверить, что текст дропнутого элемента равен '{expectedText}'")
    public DroppableSteps verifyDroppedText(String expectedText) {
        String actualText = droppablePage.getDroppedText();
        assertThat("Текст дропнутого элемента должен соответствовать ожидаемому", actualText, equalTo(expectedText));
        return this;
    }

    @Step("Проверить, что целевой элемент подсвечен")
    public DroppableSteps verifyDroppableHighlighted(SelenideElement droppable) {
        boolean isHighlighted = droppablePage.isDroppableHighlighted(droppable);
        assertThat("Целевой элемент должен быть подсвечен после дропа", isHighlighted, is(true));
        return this;
    }

    @Step("Проверить, что допустимый элемент может быть дропнут")
    public DroppableSteps verifyAcceptableDroppable() {
        // Используем JavaScript для надежного drag and drop
        dragAndDropWithJS(droppablePage.getAcceptable(), droppablePage.getDroppableAccept());
        verifyDroppedText("Dropped!");
        verifyDroppableHighlighted(droppablePage.getDroppableAccept());
        return this;
    }

    @Step("Проверить, что недопустимый элемент НЕ может быть дропнут")
    public DroppableSteps verifyNotAcceptableCannotDrop() {
        String beforeDropText = droppablePage.getDroppedText();
        dragAndDropWithJS(droppablePage.getNotAcceptable(), droppablePage.getDroppableAccept());
        String afterDropText = droppablePage.getDroppedText();
        assertThat("Текст не должен измениться после попытки дропа недопустимого элемента",
                afterDropText, equalTo(beforeDropText));
        return this;
    }

    @Step("Проверить, что внутренний droppable (не жадный) получает дроп")
    public DroppableSteps verifyNotGreedyInnerReceivesDrop() {
        dragAndDropWithJS(droppablePage.getDragBox(), droppablePage.getNotGreedyInner());
        verifyDroppableHighlighted(droppablePage.getNotGreedyInner());
        return this;
    }

    @Step("Проверить, что внешний droppable (не жадный) также получает дроп")
    public DroppableSteps verifyNotGreedyOuterReceivesDrop() {
        boolean isHighlighted = droppablePage.isDroppableHighlighted(droppablePage.getNotGreedyOuter());
        assertThat("Внешний не жадный элемент должен быть подсвечен", isHighlighted, is(true));
        return this;
    }

    @Step("Проверить, что жадный внутренний droppable получает дроп")
    public DroppableSteps verifyGreedyInnerReceivesDrop() {
        dragAndDropWithJS(droppablePage.getDragBox(), droppablePage.getGreedyInner());
        verifyDroppableHighlighted(droppablePage.getGreedyInner());
        return this;
    }

    @Step("Проверить, что жадный внутренний элемент предотвращает дроп на внешний")
    public DroppableSteps verifyGreedyPreventsOuterDrop() {
        boolean isHighlighted = droppablePage.isDroppableHighlighted(droppablePage.getGreedyOuter());
        assertThat("Внешний жадный элемент не должен быть подсвечен", isHighlighted, is(false));
        return this;
    }

    @Step("Получить начальную позицию возвращаемого элемента")
    public String getInitialRevertablePosition() {
        return droppablePage.getDraggablePosition(droppablePage.getWillRevert());
    }

    @Step("Проверить, что возвращаемый элемент вернулся на исходную позицию")
    public DroppableSteps verifyRevertableReturns(String initialPosition) {
        dragAndDropWithJS(droppablePage.getWillRevert(), droppablePage.getDroppableRevert());
        String positionAfterRevert = droppablePage.getDraggablePosition(droppablePage.getWillRevert());
        assertThat("Элемент должен вернуться на исходную позицию", positionAfterRevert, equalTo(initialPosition));
        return this;
    }

    @Step("Проверить, что невозвращаемый элемент остается в позиции дропа")
    public DroppableSteps verifyNotRevertableStays() {
        String positionBeforeDrop = droppablePage.getDraggablePosition(droppablePage.getNotRevert());
        dragAndDropWithJS(droppablePage.getNotRevert(), droppablePage.getDroppableRevert());
        String positionAfterDrop = droppablePage.getDraggablePosition(droppablePage.getNotRevert());
        assertThat("Позиция элемента должна измениться после дропа", positionAfterDrop, not(equalTo(positionBeforeDrop)));
        return this;
    }

    @Step("Подождать анимации возврата элемента")
    public DroppableSteps waitForRevertAnimation() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;
    }
}