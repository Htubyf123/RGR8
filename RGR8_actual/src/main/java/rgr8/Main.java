package rgr8;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
 
 @Override
 public void start(final Stage stage) {
  try {
   Parent root;
   FXMLLoader loader = new FXMLLoader();
   loader.setClassLoader(getClass().getClassLoader());
   loader.setLocation(getClass().getResource("/SceneMenu.fxml"));
   root = loader.load();
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.setResizable(false);
   stage.show();
   stage.setTitle("Калькулятор");
   
//Добавление подтверждения закрытия окна   
   stage.setOnCloseRequest(event -> {
	   event.consume();
	   CloseProgramm(stage);
   });
   
   
   
  } catch(Exception e) {
   e.printStackTrace();
  }
 }
 
//Добавление окна для подтверждения закрытия  
public void CloseProgramm (Stage stage) {
	 
	 Alert alert = new Alert(AlertType.CONFIRMATION);
	 alert.setTitle("Выход");
	 alert.setHeaderText("Вы действительно хотите закрыть окно?");
	 
	 if(alert.showAndWait().get() == ButtonType.OK) {
	 stage.close();
	 
}
}


 
 public static void main(String[] args) {
	  launch(args);
	 }
	}

 