package com.api.constant;

/**
 * �ֵ������
 * 
 * @author HCK
 *
 */
public class DictConstants {

	/******************************** ����ģ�� STA ********************************/
	/**
	 * ����ģ�飺��¼
	 */
	public static final String OPERATE_MODEL_LOGIN = "operate_model_login";

	/**
	 * ����ģ�飺վ�����
	 */
	public static final String OPERATE_MODEL_SITE = "operate_model_site";

	/**
	 * ����ģ�飺���ݴ洢����
	 */
	public static final String OPERATE_MODEL_NFSBACKUP = "operate_model_nfsBackup";

	/**
	 * ����ģ�飺�������
	 */
	public static final String OPERATE_MODEL_AREA = "operate_model_area";

	/**
	 * ����ģ�飺��Ⱥ����
	 */
	public static final String OPERATE_MODEL_CLUSTER = "operate_model_cluster";

	/**
	 * ����ģ�飺���ι���
	 */
	public static final String OPERATE_MODEL_NETWORKING = "operate_model_networking";

	/**
	 * ����ģ�飺����������
	 */
	public static final String OPERATE_MODEL_SOFTWAREIMAGE = "operate_model_softwareImage";
	
	/**
	 * ����ģ�飺��������
	 */
	public static final String OPERATE_MODEL_HOST = "operate_model_host";
	
	/**
	 * ����ģ�飺��������
	 */
	public static final String OPERATE_MODEL_ORDER = "operate_model_order";
	/******************************** ����ģ�� END ********************************/

	/******************************** �������� STA ********************************/
	/**
	 * ������������¼
	 */
	public static final String OPERATE_ACTION_LOGIN = "operate_action_login";

	/**
	 * ����������ע��
	 */
	public static final String OPERATE_ACTION_REGISTER = "operate_action_register";

	/**
	 * ��������������
	 */
	public static final String OPERATE_ACTION_ADD = "operate_action_add";
	
	/**
	 * �����������༭
	 */
	public static final String OPERATE_ACTION_UPDATE = "operate_action_update";

	/**
	 * ����������ע��
	 */
	public static final String OPERATE_ACTION_DEREGISTER = "operate_action_deregister";

	/**
	 * ����������ɾ��
	 */
	public static final String OPERATE_ACTION_DELETE = "operate_action_delete";
	
	/**
	 * �������������
	 */
	public static final String OPERATE_ACTION_INPUT = "operate_action_input";
	
	/**
	 * ��������������
	 */
	public static final String OPERATE_ACTION_OUTPUT = "operate_action_out";
	
	/**
	 * �������������
	 */
	public static final String OPERATE_ACTION_AUDIT = "operate_action_audit";
	
	/**
	 * ����������ִ��
	 */
	public static final String OPERATE_ACTION_EXECUTE = "operate_action_execute";
	/******************************** ������̬ END ********************************/

	/******************************* mgm״̬ STA ********************************/
	/**
	 * mgm״̬:����
	 */
	public static final String STATUS_MGM_PASSING = "passing";

	/**
	 * mgm״̬:�澯
	 */
	public static final String STATUS_MGM_WARNING = "warning";

	/**
	 * mgm״̬:�쳣
	 */

	public static final String STATUS_MGM_CRITICAL = "critical";
	/******************************* mgm״̬ END ********************************/

	/******************************** hs״̬ STA ********************************/
	/**
	 * hs״̬:����
	 */
	public static final String STATUS_HS_PASSING = "passing";

	/**
	 * hs״̬:�澯
	 */
	public static final String STATUS_HS_WARNING = "warning";

	/**
	 * hs״̬:�쳣
	 */
	public static final String STATUS_HS_CRITICAL = "critical";
	/******************************** hs״̬ END ********************************/

	/****************************** ����������� STA ******************************/
	/**
	 * ����������ͣ��������
	 */
	public static final String TASK_OBJ_TYPE_SOFTWAREIMAGE = "softwareImage";
	
	/**
	 * ����������ͣ�����
	 */
	public static final String TASK_OBJ_TYPE_HOST = "host";
	
	/**
	 * ����������ͣ�����
	 */
	public static final String TASK_OBJ_TYPE_ORDER = "order";
	
	/**
	 * ����������ͣ��ӹ���
	 */
	public static final String TASK_OBJ_TYPE_SUBORDER = "subOrder";
	/****************************** ����������� END ******************************/
	
	/****************************** ���������� STA ******************************/
	/**
	 * ���������ͣ�����
	 */
	public static final String TASK_ACTION_TYPE_CREATE = "create";
	
	/**
	 * ���������ͣ����
	 */
	public static final String TASK_ACTION_TYPE_INPUT = "input";
	
	/**
	 * ���������ͣ�����
	 */
	public static final String TASK_ACTION_TYPE_OUTPUT = "output";
	
	/**
	 * ���������ͣ�ִ��
	 */
	public static final String TASK_ACTION_TYPE_EXECUTE = "execute";
	/****************************** ���������� END ******************************/
	
	/*************************** ����/������ִ��״̬ STA ***************************/
	/**
	 * ����/������ִ��״̬��δ֪
	 */
	public static final String TASK_STATUS_UNKNOWN = "unknown";
	/**
	 * ����/������ִ��״̬��δ����
	 */
	public static final String TASK_STATUS_CREATE_NO = "create_no";
	/**
	 * ����/������ִ��״̬�������ɹ�
	 */
	public static final String TASK_STATUS_CREATE_SUCCESS = "create_success";

	/**
	 * ����/������ִ��״̬��������
	 */
	public static final String TASK_STATUS_CREATE_RUNNING = "create_running";

	/**
	 * ����/������ִ��״̬������ʧ��
	 */
	public static final String TASK_STATUS_CREATE_FAILURE = "create_failure";
	
	/**
	 * ����/������ִ��״̬��δ���
	 */
	public static final String TASK_STATUS_INPUT_NO = "input_no";
	
	/**
	 * ����/������ִ��״̬�����ɹ�
	 */
	public static final String TASK_STATUS_INPUT_SUCCESS = "input_success";

	/**
	 * ����/������ִ��״̬�������
	 */
	public static final String TASK_STATUS_INPUT_RUNNING = "input_running";

	/**
	 * ����/������ִ��״̬�����ʧ��
	 */
	public static final String TASK_STATUS_INPUT_FAILURE = "input_failure";
	
	/****************************** ����ִ��״̬ END ******************************/

	/***************************** ���������״̬ STA *****************************/
	/**
	 * ���������״̬����������
	 */
	public static final int SUBTASK_STATUS_CREATE = 1;

	/**
	 * ���������״̬��ִ����
	 */
	public static final int SUBTASK_STATUS_RUNNING = 2;
	
	/**
	 * ���������״̬��������ֹ,δ���
	 */
	public static final int SUBTASK_STATUS_STOP = 3;
	
	/**
	 * ���������״̬������δִ�У���ȡ��
	 */
	public static final int SUBTASK_STATUS_CANCEL = 4;
	
	/**
	 * ���������״̬���������
	 */
	public static final int SUBTASK_STATUS_DONE = 5;
	
	/**
	 * ���������״̬������ʱ
	 */
	public static final int SUBTASK_STATUS_TIMEOUT = 6;

	/**
	 * ���������״̬������ʧ��
	 */
	public static final int SUBTASK_STATUS_FAILE = 7;
	/***************************** ���������״̬ END *****************************/
	
	/******************************** �������� STA ********************************/
	/**
	 * �������ͣ��������Ͷ���
	 */
	public static final String ORDER_TYPE_CREATE = "create";
	/******************************** �������� END ********************************/

	/******************************** ����״̬ STA ********************************/
	/**
	 * ����״̬��δ����
	 */
	public static final String ORDER_STATUS_UNAPPROVED = "unapproved";
	/**
	 * ����״̬������ͨ��
	 */
	public static final String ORDER_STATUS_APPROVED = "approved";
	/**
	 * ����״̬�������ܾ�
	 */
	public static final String ORDER_STATUS_UNAPPROVE = "unapprove";
	/**
	 * ����״̬����ִ��
	 */
	public static final String ORDER_STATUS_EXECUTED = "executed";
	/******************************** ����״̬ END ********************************/
}
