package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {

	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			showNonExistTarget();
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.print(employee);
			}
		}
	}

	public static void showNonExistTarget() {
		System.out.println(ConstantMsg.MSG_ERROR);
	}

	public static void showHeader() {
		System.out.println(ConstantMsg.MSG_TABLE_HEADER);
	}

}
