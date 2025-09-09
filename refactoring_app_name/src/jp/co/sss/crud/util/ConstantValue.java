package jp.co.sss.crud.util;

public class ConstantValue {
	/** 全件検索(1) */
	public static final int MENU_FIND_ALL = 1;
	/** 社員名検索(2) */
	public static final int MENU_FIND_BY_EMP_NAME = 2;
	/** 部署ID検索(3) */
	public static final int MENU_FIND_BY_DEPT_ID = 3;
	/** 新規登録(4) */
	public static final int MENU_INSERT = 4;
	/** 更新(5) */
	public static final int MENU_UPDATE = 5;
	/** 削除(6) */
	public static final int MENU_DELETE = 6;
	/** 終了(7) */
	public static final int MENU_END = 7;

	/** 性別：回答なし */
	public static final int GENDER_UNKOWN = 0;
	/** 性別：男性 */
	public static final int GENDER_MALE = 1;
	/** 性別：女性 */
	public static final int GENDER_FEMALE = 2;
	/** 性別：その他 */
	public static final int GENDER_OTHER = 9;

	/** 部署：営業部 */
	public static final int DEPT_SALES = 1;
	/** 部署：経理部 */
	public static final int DEPT_ACCOUNTING = 2;
	/** 部署：総務部 */
	public static final int DEPT_GENERAL_AFFAIRS = 3;

	/** 社員名検索時の入力値インデックス(社員名) */
	public static final int SEARCH_INDEX_EMP_NAME = 1;
	/** 部署ID検索時の入力値インデックス(部署ID) */
	public static final int SEARCH_INDEX_DEPT_ID = 1;

	/** 登録時の入力値インデックス(社員名) */
	public static final int INSERT_INDEX_EMP_NAME = 1;
	/** 登録時の入力値インデックス(性別) */
	public static final int INSERT_INDEX_GENDER = 2;
	/** 登録時の入力値インデックス(誕生日) */
	public static final int INSERT_INDEX_BIRTHDAY = 3;
	/** 登録時の入力値インデックス(部署ID) */
	public static final int INSERT_INDEX_DEPT_ID = 4;

	/** 更新時の入力値インデックス(社員名) */
	public static final int UPDATE_INDEX_EMP_NAME = 1;
	/** 更新時の入力値インデックス(性別) */
	public static final int UPDATE_INDEX_GENDER = 2;
	/** 更新時の入力値インデックス(誕生日) */
	public static final int UPDATE_INDEX_BIRTHDAY = 3;
	/** 更新時の入力値インデックス(部署ID) */
	public static final int UPDATE_INDEX_DEPT_ID = 4;
	/** 更新時の入力値インデックス（社員ID）*/
	public static final int UPDATE_INDEX_EMP_ID = 5;

	/** 削除時の入力値インデックス (社員ID) */
	public static final int DELETE_INDEX_EMP_ID = 1;

}
