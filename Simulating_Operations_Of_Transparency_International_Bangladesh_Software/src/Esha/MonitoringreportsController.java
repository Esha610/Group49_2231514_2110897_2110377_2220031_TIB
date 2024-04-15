package Esha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MonitoringReportsController implements Initializable {

    @FXML
    private ListView<String> reportsListView;
    @FXML
    private TextArea reportDetailsTextArea;

@Override
public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> reportList = FXCollections.observableArrayList();
  
    // Adding report names to the list
    reportList.addAll(
        "Sales Performance Report",
        "Marketing Analysis Report",
        "Financial Statement Report",
        "Customer Satisfaction Survey Report",
        "Project Progress Report",
        "Employee Performance Evaluation Report",
        "Market Research Report",
        "Inventory Management Report",
        "Quality Assurance Report",
        "Annual Budget Report"
    );

  
    reportsListView.setItems(reportList);

    
    reportsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            String reportDetails = fetchReportDetails(newValue.toString());
            reportDetailsTextArea.setText(reportDetails);
        }
    });
}

    private String fetchReportDetails(String reportName) {
        
        switch (reportName) {
            case "Sales Performance Report":
                return "This report analyzes the sales performance of the company over a specific period.";
            case "Marketing Analysis Report":
                return "This report provides insights into marketing campaigns, customer demographics, and competitor analysis.";
            case "Financial Statement Report":
                return "This report includes the company's financial statements such as income statement, balance sheet, and cash flow statement.";
            case "Customer Satisfaction Survey Report":
                return "This report summarizes the results of customer satisfaction surveys and identifies areas for improvement.";
            case "Project Progress Report":
                return "This report tracks the progress of ongoing projects, including milestones achieved and remaining tasks.";
            case "Employee Performance Evaluation Report":
                return "This report evaluates employee performance based on key performance indicators and goals set.";
            case "Market Research Report":
                return "This report presents findings from market research studies, including consumer preferences and market trends.";
            case "Inventory Management Report":
                return "This report assesses the status of inventory levels, turnover rates, and reorder points.";
            case "Quality Assurance Report":
                return "This report examines product quality and identifies any defects or issues found during quality control processes.";
            case "Annual Budget Report":
                return "This report outlines the company's budget for the fiscal year, including revenue projections and expenditure allocations.";
            default:
                return "No details available for this report.";
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
       
        System.out.println("Going back...");
    }

    @FXML
    private void exitApplication(ActionEvent event) {
      
        System.exit(0);
    }

    @FXML
    private void viewReport(ActionEvent event) {
      
        String selectedReport = reportsListView.getSelectionModel().getSelectedItem().toString();
       
        String reportDetails = "Sample report details for " + selectedReport;
        reportDetailsTextArea.setText(reportDetails);
    }

    @FXML
    private void downloadReport(ActionEvent event) {
      
        String selectedReport = reportsListView.getSelectionModel().getSelectedItem().toString();
        System.out.println("Downloading report: " + selectedReport);
       
    }
}
