/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class TelaMainController implements Initializable {

    @FXML
    private AnchorPane painelImportacoes;
    @FXML
    private Pane telaPrincipal;
    @FXML
    private TextArea labelFrases;
    @FXML
    private Button buttonResposta;
    @FXML
    private Label labelResposta;
    @FXML
    private Button ButtonGerarFrase;
    @FXML
    private Label labelErro;
    @FXML
    private Label habilitarEasterEgg;
    @FXML
    private Pane BackgroundPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void menuButtonFerrariFolle(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacaoFerrariFolle.fxml"));
    }

    @FXML
    private void menuButtonInfoPecas(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("informacoesImportacao.fxml"));
    }

    @FXML
    private void menuButtonAlpha7(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ImportacaoAlpha7.fxml"));
    }

    @FXML
    private void menuButtonFolleCosta(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacaoFolleCosta.fxml"));
    }

    @FXML
    private void menuButtonEcoCapivari(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacaoEconomicaCapivari.fxml"));
    }

    public Node getNode(String node) {
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (IOException e) {
        }
        return no;

    }

    @FXML
    private void menuButtonDotta(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ImportacaoDotta.fxml"));
    }

    @FXML
    private void menuButtonExtratoCapivari(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ExtratoDrogaEcoCapivari.fxml"));
    }

    @FXML
    private void buttonCapa(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("CapaJava.fxml"));
    }

    @FXML
    private void menuButtonItens(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ItensJava.fxml"));
    }

    @FXML
    private void ButtonResposta(ActionEvent event) {
        String texto = labelFrases.getText();
        System.out.println(texto);
        if (texto.equals("Adivinhe: Qual é o animal peçonhento que trabalha com montaria?")) {
            labelResposta.setText("É o escor-peão.");
            labelResposta.setVisible(true);
        } else if (texto.equals("Adivinhe: Qual a lua que nunca sente fome?")) {
            labelResposta.setText("A lua cheia! :)");
            labelResposta.setVisible(true);
        } else if (texto.equals("Adivinhe: Qual o ovo mais escuro que existe?")) {
            labelResposta.setText("Ovinho tinto.");
            labelResposta.setVisible(true);
        } else if (texto.equals("Adivinhe: No trânsito, como fazer para as dores corporais passarem mais depressa?")) {
            labelResposta.setText("É só pisar no acelera-dor.");
            labelResposta.setVisible(true);
        }

    }

    @FXML
    private void buttonGerarFrase(ActionEvent event) {
        labelFrases.setVisible(true);
        labelResposta.setVisible(false);
        buttonResposta.setVisible(false);
        List<String> frases = Arrays.asList("Lembre-se: Tudo depende da flexibilidade da lagartixa.", "Reflita: Em terra de cego, ser cego não é mais que a obrigação!", "Utilize a frase: Isso é coisa de quem sai da piscina pela escadinha.", "Utilize a frase: Isso é coisa de quem toma banho de chinelo", "Pense: Errar é humano, persistir no erro é americano, acertar o alvo é mulsumano.", "Reflita: Suicidio é um pecado mortal.", "Reflita:  O espelho deveria pensar duas vezes antes de refletir.",
                "Verbo cavar: Eu cavo, tu cavas, eles cavam, vós cavais. Não é bonito mas é profundo.", "Adivinhe: Qual a lua que nunca sente fome?", "Para reflexão: Se eu pegar um copo de leite e um chocolate amargo, e colocar o chocolate no leite. Ele ira virar chocolate amargo ao leite?", "Motivacional: Pense e haja como caçador e não como caça.", "Reflexão: Jamais apagarás um contato, um dia ele pode abrir uma pizzaria.", "Adivinhe: Qual é o animal peçonhento que trabalha com montaria?",
                "Adivinhe: Qual o ovo mais escuro que existe?", "Adivinhe: No trânsito, como fazer para as dores corporais passarem mais depressa?");
        String texto = frases.get(new Random().nextInt(frases.size()));
        switch (texto) {
            case "Adivinhe: Qual a lua que nunca sente fome?":
                buttonResposta.setVisible(true);
                labelFrases.setText(texto);
                break;
            case "Adivinhe: Qual é o animal peçonhento que trabalha com montaria?":
                buttonResposta.setVisible(true);
                labelFrases.setText(texto);
                break;
            case "Adivinhe: Qual o ovo mais escuro que existe?":
                buttonResposta.setVisible(true);
                labelFrases.setText(texto);
                break;
            case "Adivinhe: No trânsito, como fazer para as dores corporais passarem mais depressa?":
                buttonResposta.setVisible(true);
                labelFrases.setText(texto);
                break;
            default:
                labelFrases.setText(texto);
                break;
        }

    }

    @FXML
    private void easterEgg(MouseEvent event) {
        labelErro.setVisible(true);

    }

    @FXML
    private void gerarEasterEgg(MouseEvent event) {
        labelErro.setVisible(false);
        ButtonGerarFrase.setVisible(true);
    }

    @FXML
    private void menuButtonGammaCapa(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("GammaCapa.fxml"));
    }

    @FXML
    private void buttonConciliacaoAmeripan(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ConciliacaoContabil.fxml"));
    }
}
