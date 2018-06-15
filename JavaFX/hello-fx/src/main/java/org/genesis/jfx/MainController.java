package org.genesis.jfx;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MainController
 * @Package org.genesis.jfx
 * @Description: main controller of java fx
 * @date 2018/6/15 16:53
 */
public class MainController {

    @FXML
    public void handlerBtnClick(ActionEvent event) {
        Button btnSource = (Button) event.getSource();
        btnSource.setText("I am clicked!");
    }
}
