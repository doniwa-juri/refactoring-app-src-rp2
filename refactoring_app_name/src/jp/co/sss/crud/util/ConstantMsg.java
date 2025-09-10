package jp.co.sss.crud.util;

public class ConstantMsg {

	/** メニューの表示 */
	public static final String MSG_MANU = """
			=== 社員管理システム ===
			1.全件表示
			2.社員名検索
			3.部署ID検索
			4.新規登録
			5.更新
			6.削除
			7.終了
			メニュー番号を入力してください：""";

	/** 社員名を入力させる */
	public static final String MSG_EMP_NAME = "社員名：";
	/** 部署IDを入力させる */
	public static final String MSG_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)：";
	/** 性別を入力させる */
	public static final String MSG_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	/** 誕生日を入力させる */
	public static final String MSG_BIRTHDAY = "生年月日(西暦年/月/日):";

	/** 登録完了メッセージ */
	public static final String MSG_INSERT_COMP = "社員情報を登録しました";

	/** 更新する社員の社員IDを入力させる　*/
	public static final String MSG_UPDATE_INFO = "更新する社員の社員IDを入力してください：";
	/** 更新完了メッセージ */
	public static final String MSG_UPDATE_COMP = "社員情報を更新しました";

	/** 削除する社員の社員IDを入力させる */
	public static final String MSG_DELETE_INFO = "削除する社員の社員IDを入力してください：";
	/** 削除完了メッセージ */
	public static final String MSG_DELETE_COMP = "社員情報を削除しました";

	/** 終了メッセージ */
	public static final String MSG_END = "システムを終了します。";

	/** エラーメッセージ */
	public static final String MSG_ERROR = "該当者はいませんでした";

	/** 見出し */
	public static final String MSG_TABLE_HEADER = "社員ID\t社員名\t性別\t生年月日\t部署名";

	/** 回答なし（性別）*/
	public static final String GENDER_UNKOWN = "回答なし";
	/** 男性（性別）*/
	public static final String GENDER_MALE = "男性";
	/** 女性（性別）*/
	public static final String GENDER_FEMALE = "女性";
	/** その他（性別）*/
	public static final String GENDER_OTHER = "その他";

	/** 営業部（部署）*/
	public static final String DEPT_SALES = "営業部";
	/** 経理部（部署） */
	public static final String DEPT_ACCOUNTING = "経理部";
	/** 総務部（部署） */
	public static final String DEPT_GENERAL_AFFAIRS = "総務部";
	/** 回答なし、その他（部署）*/
	public static final String DEPT_UNKOWN = "回答なし";

}
