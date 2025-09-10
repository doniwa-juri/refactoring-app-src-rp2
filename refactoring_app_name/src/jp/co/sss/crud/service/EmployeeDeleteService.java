package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		int result = 0;
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		int empId = (int) empIdReader.input();

		result = employeeDAO.delete(empId);

		if (result == 1) {
			System.out.println(ConstantMsg.MSG_DELETE_COMP);
		}

	}

}
