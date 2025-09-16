package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeUpdateService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalInputException {

		//更新する社員の社員IDを入力
		System.out.print(ConstantMsg.MSG_UPDATE_INFO);
		EmployeeEmpIdReader empIdReader = new EmployeeEmpIdReader();
		int empId = (int) empIdReader.input();

		//社員名を入力
		EmployeeNameReader empNameReader = new EmployeeNameReader();
		System.out.print(ConstantMsg.MSG_EMP_NAME);
		String empName = (String) empNameReader.input();

		//性別を入力
		EmployeeGenderReader genderReader = new EmployeeGenderReader();
		System.out.print(ConstantMsg.MSG_GENDER);
		int gender = (int) genderReader.input();

		//誕生日を入力
		EmployeeBirthdayReader birthdayReader = new EmployeeBirthdayReader();
		System.out.print(ConstantMsg.MSG_BIRTHDAY);
		String birthday = (String) birthdayReader.input();

		//部署IDを入力
		EmployeeDeptIdReader deptIdReader = new EmployeeDeptIdReader();
		System.out.print(ConstantMsg.MSG_DEPT_ID);
		int deptId = (int) deptIdReader.input();

		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setGender(gender);
		emp.setBirthday(birthday);

		Department dept = new Department();
		dept.setDeptId(deptId);
		emp.setDepartment(dept);

		EmployeeDAO employeeDAO = new EmployeeDAO();
		int result = employeeDAO.update(emp);
		ConsoleWriter.showCompleteUpdate(result);
	}

}
