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

	/** 更新する社員の社員IDを入力させる　*/
	public static final String MSG_UPDATE_INFO = "更新する社員の社員IDを入力してください：";

	/** 更新完了メッセージ */
	public static final String MSG_UPDATE_COMP = "社員情報を更新しました";

	/** 削除する社員の社員IDを入力させる */
	public static final String MSG_DELETE_INFO = "削除する社員の社員IDを入力してください：";

	/** 終了メッセージ */
	public static final String MSG_END = "システムを終了します。";

}
