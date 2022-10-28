package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class AutoException extends Exception {
	private int errNo;
	private String errMsg;
	
	//errNo 0 default if no error number is given in the constructor
	//errNo 1-99 - exception originated from model package
	//errNo 100-199 - exception originated from util package
	//errNo 200-299 - exception originated from adapter package
	//errNo 300-399 - exception originated from exception package
	//errNo 900-999 - exception originated from driver package
	
	public AutoException() {
		super();
		errNo = 0;
		logError();
	}
	public AutoException(int errNo) {
		super();
		this.errNo = errNo;
		logError();
	}
	public AutoException(String errMsg) {
		super();
		this.errMsg = errMsg;
		errNo = 0;
		logError();
	}
	public AutoException(int errNo, String errMsg) {
		super();
		this.errNo = errNo;
		this.errMsg = errMsg;
		logError();
	}
	public AutoException(String errMsg, int errNo) {
		super();
		this.errNo = errNo;
		this.errMsg = errMsg;
		logError();
	}
	
	//Getter/Setters
	public String getErrMsg() {
		if(errMsg == null) {
			return "Error message null";
		}
		else {
			return errMsg;
		}
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public int getErrNo() {
		return errNo;
	}
	public void setErrNo(int errNo) {
		this.errNo = errNo;
	}
	
	
	//Log exceptions
	public void logError() {
		//log exceptions with time stamps to a text file
		
		if(errMsg == null) {
			switch(errNo) {
			case 101:
				setErrMsg("Invalid file name");
				break;
			case 102:
				setErrMsg("Missing make/model name");
				break;
			case 103:
				setErrMsg("Missing option name");
				break;
			case 104:
				setErrMsg("Missing option price");
				break;
			case 105:
				setErrMsg("Missing submodel name");
				break;
			case 201:
				setErrMsg("No submodel with that name found");
				break;
			case 202:
				setErrMsg("No option with that name found");
				break;
			default:
				setErrMsg("Unknown Error");
			}
		}
		
		try {
			LocalDateTime date = LocalDateTime.now();
			FileWriter fileWriter = new FileWriter("error_log.txt", true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.append(date + ": Error Number " + errNo + " " + errMsg);
			bw.newLine();
			bw.close();
			fileWriter.close();
		}
		catch(Exception e) {
			
		}
	}

}
