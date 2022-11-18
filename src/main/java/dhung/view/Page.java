package dhung.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Page {

    private Page parentPage = null;
    private List<Page> childrenPage = new ArrayList<>();
    private AnchorPane root = null;
    private String type = null;
    public Page(){}
    public Page(String type) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(type));
        fxmlLoader.setController(this);
        fxmlLoader.load();
        root =(AnchorPane) fxmlLoader.getRoot();
        this.type=type;

    }

    public AnchorPane getRoot(){
        return root;
    }
    public Page getParent() {
        return parentPage;
    }
    public void setParent(Page page){
        parentPage = page;
    }
    public void setRoot(AnchorPane anchorPane){
        this.root =anchorPane;
    }
    public List<Page> getChildren(){
        return this.childrenPage;
    }

    public void add(Page page){
        childrenPage.add(page);
        this.root.getChildren().add(page.getRoot());
        page.setParent(this);
    }
    public boolean has(Page page) {
        return childrenPage.contains(page);
    }
    public void toFront() {
        root.toFront();
    }
    public void toBack() {
        root.toBack();
    }
    public void show(Page page) {
        page.toFront();
    }
    public void unShow(Page page){
        page.toBack();
    }
    public void remove(Page page){
        childrenPage.remove(page);
        this.root.getChildren().remove(page.getRoot());
        page.setParent(null);
    }
    public void close(){
        if(parentPage!=null) {
            parentPage.remove(this);
        }
        childrenPage.clear();
        parentPage=null;
        root = null;
        type=null;

    }
}
