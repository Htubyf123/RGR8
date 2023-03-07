package rgr8;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SceneController implements Initializable{

 private Stage stage;
 @FXML 
 private Parent root;
 
 @FXML
 MenuBar myMenuBar; 
 
 @FXML
 private ResourceBundle resources;

 @FXML
 private URL location;

 @FXML
 private MenuItem menuClose, menuInfo;


 @FXML
 private ImageView myImageView1, myImageView2, myImageView3;

 
 @FXML
 private Slider sliderVert1, sliderHor1;
 
 @FXML
 private ComboBox<String> windowQuantity, windowType;

 @FXML
 private Label labelVert, labelHor;

 
 @FXML
 private Label windowSum, quantitySum, optionsSum, itogSum;

 @FXML
 private RadioButton rButton1, rButton2;

 @FXML
 private Button raschetButton, createButton;
 
 @FXML
 private TextField textHor1, textVert1;

 @FXML
 private Label widthLabel, heightLabel, mmLabel1, mmLabel2;
 
	variables var = new variables();
	 int typeSum = 0;
	 int x, lenghtHor1;
	 int dopSteklo = 0;
	 boolean isDopSteklo = false;
	 static final double MNOJ = 0.44;
	 static int stoimWindow = 2000;
	 static int podCost = 500;
	 static int otlivCost = 250;



	 
		public void switchToSceneInfo(ActionEvent event) {
			 Alert alert = new Alert(AlertType.CONFIRMATION);
			 alert.setTitle("���������� � �������������");
			 alert.setHeaderText("1. ���������:\n ���������� ������\n2. ����������� 1:\n ���������� ������\n3. ����������� 2:\n ������� ��������\n4 ����������� 3\n ������� ��������");
			 
			 if(alert.showAndWait().get() == ButtonType.OK) {
				 stage = (Stage) root.getScene().getWindow();
		}
}


	//���������� ���� ��� ������������� ��������
	public void CloseProgramm (ActionEvent event) {
		 
		 Alert alert = new Alert(AlertType.CONFIRMATION);
		 alert.setTitle("�����");
		 alert.setHeaderText("�� ������������� ������ ������� ����?");
		 
		 if(alert.showAndWait().get() == ButtonType.OK) {
		 stage = (Stage) root.getScene().getWindow();
		 stage.close();
		 
	}
	}
 
 
 
 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//���������� �������� ��� ������		
		sliderVert1.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				var.setLenghtVert((int) sliderVert1.getValue());
				labelVert.setText(Integer.toString(var.getLenghtVert()) + " ��");
				
			}
			
		});
			
//���������� �������� ��� ������		
		sliderHor1.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed (ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				var.setLenghtHor1((int) sliderHor1.getValue());
				labelHor.setText(Integer.toString(var.getLenghtHor1()) + " ��");
				
			}
			
		});	


		
//���������� �������		
		windowType.getItems().addAll("��������������","��������������","�������������");
		windowQuantity.getItems().addAll("������������","������������");

//���������� �������� ������ �������		
		windowType.setOnAction(this::typeChangeAction);
		windowQuantity.setOnAction(this::quantityChangeAction);
		
		
//������ ��������� ����			
		ChangeListener<Number> change = new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				countWindowSize();
				dopStekloCheck();
				dopOptionsCheck();
				sumCount();
				
				windowSum.setText(Integer.toString(var.getTypeSum()) + " ������");
				
				
				
			}
		};
		
		sliderHor1.valueProperty().addListener(change);
		sliderVert1.valueProperty().addListener(change);		
		textHor1.textProperty().bindBidirectional(sliderHor1.valueProperty(), NumberFormat.getIntegerInstance());
		textVert1.textProperty().bindBidirectional(sliderVert1.valueProperty(), NumberFormat.getIntegerInstance());
}

 
//�������, ����������� ������� �� �����
 	public void dopOptionsCheck() {

		if(rButton1.isSelected()) {
			var.setPod(podCost + (int)(var.getLenghtHor1()*0.4));
		} else if(!rButton1.isSelected()) {
			var.setPod(0);
		}
		if(rButton2.isSelected()) {
			var.setOtliv(otlivCost + (int)(var.getLenghtHor1()*0.6));
		} else if(!rButton2.isSelected()) {
			var.setOtliv(0);
		}
		var.setSumOptions(var.getPod() + var.getOtliv());
		optionsSum.setText(Integer.toString(var.getSumOptions()) + " ������");
 	}
 	
//�������, ����������� ������ �� �������������� �����������
 	public void dopStekloCheck() {
		if (isDopSteklo) {
			var.setDopSteklo((int)(var.getTypeSum() * MNOJ));
		} else { 
			var.setDopSteklo(0); 
		}
		quantitySum.setText(var.getDopSteklo() + " ������");
	}

//�������, ������� ������� �������� ��������� ����� ����
 	public void sumCount() { 
 		itogSum.setText((int)(var.getTypeSum() + var.getDopSteklo() + var.getSumOptions()) + " ������");
 	}
 	
//������ ��������� �������������
 	public void quantityChangeAction(ActionEvent event) {
 		if(windowQuantity.getSelectionModel().isSelected(0)) {
 			isDopSteklo = false;
 		} else if(windowQuantity.getSelectionModel().isSelected(1)) {
 			isDopSteklo = true;
 		}
 		dopStekloCheck();
 		sumCount();
 	}

//������ ��������� ����	
 	public void countWindowSize() {
 		int w = var.getLenghtHor1();
 		int h = var.getLenghtVert();
 		double c = 0.7;
 		var.setTypeSum( (int) (stoimWindow + (w + h)*c));
 	}


//������ ��������� �����
	public void getOptions(ActionEvent event) {
		dopOptionsCheck();
		sumCount();
	}


//������ ��� �������� ��� �����
	
 	public void createPdfButton(ActionEvent event) {
 		int opt = 0;
 		if(rButton1.isSelected()) {
 			opt = opt + 1;
 		}
 		if(rButton2.isSelected()) {
 			opt = opt + 2;
 		}
 		CreatePdf.create(windowType.getSelectionModel().getSelectedIndex(), windowQuantity.getSelectionModel().getSelectedIndex(), opt, windowSum.getText(), quantitySum.getText(), optionsSum.getText(), itogSum.getText());
 	}
 	
//����� ���� ���� 	
 	public void typeChangeAction(ActionEvent event) {
			sliderHor1.setVisible(true);
			sliderVert1.setVisible(true);
 			sliderVert1.setMax((int) 2000);
 			sliderVert1.setMin((int)500);
			sliderHor1.setMajorTickUnit(100);
 			textHor1.setVisible(true);
 			textVert1.setVisible(true);
 			widthLabel.setVisible(true);
 			heightLabel.setVisible(true);
 			mmLabel1.setVisible(true);
 			mmLabel2.setVisible(true);
			if(windowQuantity.getSelectionModel().isEmpty()) {
			windowQuantity.getSelectionModel().select(0);
			}
 		if(windowType.getSelectionModel().isSelected(0)) {
 			myImageView1.setVisible(true);
 			myImageView2.setVisible(false);
 			myImageView3.setVisible(false);
 			sliderHor1.setMax((int)1000);
 			sliderHor1.setMin((int)500);
 		} else if(windowType.getSelectionModel().isSelected(1)) {
 			myImageView1.setVisible(false);
 			myImageView2.setVisible(true);
 			myImageView3.setVisible(false);
 			sliderHor1.setMax((int)2000);
 			sliderHor1.setMin((int)1000);
 		} else if(windowType.getSelectionModel().isSelected(2)) {
 			myImageView1.setVisible(false);
 			myImageView2.setVisible(false);
 			myImageView3.setVisible(true);
 			sliderHor1.setMax((int)3000);
 			sliderHor1.setMin((int)1500);
 			sliderHor1.setMajorTickUnit(250);
 		}
 	}

 
}

