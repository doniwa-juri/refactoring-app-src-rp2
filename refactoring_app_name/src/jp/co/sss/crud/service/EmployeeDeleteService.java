package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {

		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();

		System.out.print(ConstantMsg.MSG_DELETE_INFO);
		int empId = (int) empIdReader.input();

		int result = employeeDAO.delete(empId);
		ConsoleWriter.showCompleteDeletre(result);

	}

}
