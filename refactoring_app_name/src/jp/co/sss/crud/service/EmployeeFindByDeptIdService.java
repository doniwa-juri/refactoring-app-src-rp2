package jp.co.sss.crud.service;

import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {
		List<Employee> empList = new ArrayList<>();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();

		System.out.print(ConstantMsg.MSG_DEPT_ID);
		int deptId = (int) deptIdReader.input();

		empList = employeeDAO.findByDeptId(deptId);
		ConsoleWriter.showEmployees(empList);
	}

}
