package ui.pages.demqa.interactions;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import config.ui.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DroppablePage extends BasePage {
    private final String URL = "https://demoqa.com/droppable";

    // Tabs
    private final SelenideElement simpleTab = $("#droppableExample-tab-simple");
    private final SelenideElement acceptTab = $("#droppableExample-tab-accept");
    private final SelenideElement preventPropagationTab = $("#droppableExample-tab-preventPropogation");
    private final SelenideElement revertableTab = $("#droppableExample-tab-revertable");

    // Simple Tab elements
    private final SelenideElement draggableSimple = $("#draggable");
    private final SelenideElement droppableSimple = $("#droppable");
    private final SelenideElement dropHereText = $("#droppable p");

    // Accept Tab elements
    private final SelenideElement acceptable = $("#acceptable");
    private final SelenideElement notAcceptable = $$("#acceptDropContainer .drag-box").get(1);
    private final SelenideElement droppableAccept = $("#acceptDropContainer .drop-box");
    private final SelenideElement droppedText = $("#acceptDropContainer .drop-box p");

    // Prevent Propagation Tab elements
    private final SelenideElement dragBox = $("#dragBox");
    private final SelenideElement notGreedyOuter = $("#notGreedyDropBox");
    private final SelenideElement notGreedyInner = $("#notGreedyInnerDropBox");
    private final SelenideElement greedyOuter = $("#greedyDropBox");
    private final SelenideElement greedyInner = $("#greedyDropBoxInner");

    // Revertable Tab elements
    private final SelenideElement willRevert = $("#revertable");
    private final SelenideElement notRevert = $("#notRevertable");
    private final SelenideElement droppableRevert = $("#revertableDropContainer #droppable");

    public void openPage() {
        openUrl(URL);
    }

    // Tab navigation methods
    public void clickSimpleTab() {
        simpleTab.shouldBe(visible).click();
        sleep(500);
    }

    public void clickAcceptTab() {
        acceptTab.shouldBe(visible).click();
        sleep(500);
    }

    public void clickPreventPropagationTab() {
        preventPropagationTab.shouldBe(visible).click();
        sleep(500);
    }

    public void clickRevertableTab() {
        revertableTab.shouldBe(visible).click();
        sleep(500);
    }

    // Метод drag and drop с использованием JavaScript (наиболее надежный)
    public void dragAndDropWithJS(SelenideElement source, SelenideElement target) {
        source.shouldBe(visible);
        target.shouldBe(visible);

        String jsScript =
                "function createEvent(type, element) {" +
                        "    var event = new MouseEvent(type, {" +
                        "        view: window," +
                        "        bubbles: true," +
                        "        cancelable: true," +
                        "        clientX: element.getBoundingClientRect().left + element.offsetWidth / 2," +
                        "        clientY: element.getBoundingClientRect().top + element.offsetHeight / 2" +
                        "    });" +
                        "    return event;" +
                        "}" +
                        "var dragElement = arguments[0];" +
                        "var dropElement = arguments[1];" +
                        "var dragStartEvent = createEvent('dragstart', dragElement);" +
                        "var dragOverEvent = createEvent('dragover', dropElement);" +
                        "var dropEvent = createEvent('drop', dropElement);" +
                        "var dragEndEvent = createEvent('dragend', dragElement);" +
                        "" +
                        "dragElement.dispatchEvent(dragStartEvent);" +
                        "dropElement.dispatchEvent(dragOverEvent);" +
                        "dropElement.dispatchEvent(dropEvent);" +
                        "dragElement.dispatchEvent(dragEndEvent);";

        executeJavaScript(jsScript, source, target);
        sleep(1000);
    }

    // Drag and drop с использованием jQuery UI (если доступен)
    public void dragAndDropWithJQuery(SelenideElement source, SelenideElement target) {
        String jQueryScript =
                "var source = arguments[0];" +
                        "var target = arguments[1];" +
                        "var sourceOffset = jQuery(source).offset();" +
                        "var targetOffset = jQuery(target).offset();" +
                        "var sourceCenterX = sourceOffset.left + jQuery(source).outerWidth() / 2;" +
                        "var sourceCenterY = sourceOffset.top + jQuery(source).outerHeight() / 2;" +
                        "var targetCenterX = targetOffset.left + jQuery(target).outerWidth() / 2;" +
                        "var targetCenterY = targetOffset.top + jQuery(target).outerHeight() / 2;" +
                        "var drag = new $.Event('dragstart', { clientX: sourceCenterX, clientY: sourceCenterY });" +
                        "var drop = new $.Event('drop', { clientX: targetCenterX, clientY: targetCenterY });" +
                        "$(source).trigger(drag);" +
                        "$(target).trigger(drop);";

        executeJavaScript(jQueryScript, source, target);
        sleep(1000);
    }

    // Стандартный drag and drop Selenide
    public void dragAndDropElement(SelenideElement source, SelenideElement target) {
        source.shouldBe(visible);
        target.shouldBe(visible);
        source.dragAndDrop(DragAndDropOptions.to(target));
        sleep(1000);
    }

    // Drag and drop с Actions
    public void performDragAndDrop(SelenideElement source, SelenideElement target) {
        source.shouldBe(visible);
        target.shouldBe(visible);

        Actions actions = new Actions(webdriver().object());
        actions
                .moveToElement(source)
                .clickAndHold()
                .moveToElement(target)
                .release()
                .perform();
        sleep(1000);
    }

    // Получение текстов
    public String getDropResultText() {
        return dropHereText.shouldBe(visible).getText();
    }

    public String getDroppedText() {
        return droppedText.shouldBe(visible).getText();
    }

    // Проверка подсветки
    public boolean isDroppableHighlighted(SelenideElement droppable) {
        String backgroundColor = droppable.getCssValue("background-color");
        String borderColor = droppable.getCssValue("border-color");
        // Проверяем, изменился ли цвет (обычно при дропе добавляется класс ui-state-highlight)
        return droppable.has(cssClass("ui-state-highlight")) ||
                droppable.getAttribute("class").contains("ui-state-highlight");
    }

    // Getters для элементов
    public SelenideElement getDraggableSimple() { return draggableSimple; }
    public SelenideElement getDroppableSimple() { return droppableSimple; }
    public SelenideElement getAcceptable() { return acceptable; }
    public SelenideElement getNotAcceptable() { return notAcceptable; }
    public SelenideElement getDroppableAccept() { return droppableAccept; }
    public SelenideElement getDragBox() { return dragBox; }
    public SelenideElement getNotGreedyOuter() { return notGreedyOuter; }
    public SelenideElement getNotGreedyInner() { return notGreedyInner; }
    public SelenideElement getGreedyOuter() { return greedyOuter; }
    public SelenideElement getGreedyInner() { return greedyInner; }
    public SelenideElement getWillRevert() { return willRevert; }
    public SelenideElement getNotRevert() { return notRevert; }
    public SelenideElement getDroppableRevert() { return droppableRevert; }
    public String getDraggablePosition(SelenideElement draggable) {
        return draggable.getAttribute("style");
    }
    public String getDroppableBackgroundColor(SelenideElement droppable) {
        return droppable.getCssValue("background-color");
    }
}