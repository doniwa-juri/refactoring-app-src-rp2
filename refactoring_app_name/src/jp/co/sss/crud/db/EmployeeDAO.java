package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDAO implements IEmployeeDAO {

	/** 全件検索 
	 * @throws SQLException */
	@Override
	public List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> empList = new ArrayList<>();
		Employee employee = null;
		Department department = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);
			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);

				empList.add(employee);

				//				empList.add(employeeFromResultSet(resultSet));
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException("全件検索でエラー発生", e);

		} finally {
			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empList;
	}

	/** 社員名検索 */
	@Override
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> empList = new ArrayList<>();
		Employee employee = null;
		Department department = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());
			// 検索条件となる値をバインド
			preparedStatement.setString(ConstantValue.SEARCH_INDEX_EMP_NAME, "%" + searchName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);

				empList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException("社員名検索でエラー発生", e);
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empList;
	}

	/** 部署ID検索 */
	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> empList = new ArrayList<>();
		Employee employee = null;
		Department department = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());
			// 検索条件となる値をバインド
			preparedStatement.setInt(ConstantValue.SEARCH_INDEX_DEPT_ID, deptId);
			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				department = new Department();
				department.setDeptName(resultSet.getString("dept_name"));
				employee.setDepartment(department);

				empList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException("部署ID検索でエラー発生", e);
		} finally {
			try {
				// クローズ処理
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	/** 登録 */
	@Override
	public void insert(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.INSERT_INDEX_EMP_NAME, employee.getEmpName());
			preparedStatement.setInt(ConstantValue.INSERT_INDEX_GENDER, employee.getGender());
			preparedStatement.setObject(ConstantValue.INSERT_INDEX_BIRTHDAY, employee.getBirthday());
			preparedStatement.setObject(ConstantValue.INSERT_INDEX_DEPT_ID, employee.getDepartment());

			// SQL文を実行
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException("登録でエラー発生", e);
		} finally {
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/** 更新 */
	@Override
	public Integer update(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer result = 0;
		try {
			// データベースに接続
			connection = DBManager.getConnection();
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);
			//入力値をバインド
			preparedStatement.setString(ConstantValue.UPDATE_INDEX_EMP_NAME, employee.getEmpName());
			preparedStatement.setInt(ConstantValue.UPDATE_INDEX_GENDER, employee.getGender());
			preparedStatement.setObject(ConstantValue.UPDATE_INDEX_BIRTHDAY, employee.getBirthday());
			preparedStatement.setObject(ConstantValue.UPDATE_INDEX_DEPT_ID, employee.getDepartment());
			preparedStatement.setInt(ConstantValue.UPDATE_INDEX_EMP_ID, employee.getEmpId());
			// SQL文の実行(失敗時は戻り値0)
			result = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException("更新でエラー発生", e);

		} finally {
			try {
				// クローズ処理
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/** 削除 */
	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Integer result = 0;

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);
			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.DELETE_INDEX_EMP_ID, empId);
			// SQL文の実行(失敗時は戻り値0)
			result = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException("削除でエラー発生", e);
		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}

		return result;
	}

}
