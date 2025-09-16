package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		List<Employee> empList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeNameReader empNameReader = new EmployeeNameReader();

		System.out.print(ConstantMsg.MSG_EMP_NAME);
		String empName = (String) empNameReader.input();

		empList = employeeDAO.findByEmployeeName(empName);
		ConsoleWriter.showEmployees(empList);
	}

}
