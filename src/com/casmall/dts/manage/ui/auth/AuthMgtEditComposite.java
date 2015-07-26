package com.casmall.dts.manage.ui.auth;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.casmall.common.AuthUtil;
import com.casmall.common.StringUtil;
import com.casmall.dts.common.ColorRepository;
import com.casmall.dts.common.ImageRepository;
import com.casmall.dts.common.ObjectUtil;
import com.casmall.dts.manage.biz.domain.TsAuthMgtDTO;
import com.casmall.dts.manage.biz.mgr.TsAuthManager;
import com.casmall.dts.ui.common.CallbackIF;
import com.casmall.dts.ui.common.RoundImageComposite;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AuthMgtEditComposite extends Composite implements CallbackIF{
	protected static Log log = LogFactory.getLog(AuthMgtEditComposite.class);
	private Text txtAuthKey;
	private Composite cptButton;
	private RoundImageComposite round;
	private Composite cptHeader;
	private Button btnClear;
	private Button btnDelete;
	private Button btnSave;
	private CallbackIF callback;

	private Font defaultLabelFont = com.swtdesigner.SWTResourceManager.getFont("굴림", 14, SWT.BOLD);
	private Font defaultInputFont = com.swtdesigner.SWTResourceManager.getFont("굴림", 14, SWT.NORMAL);

	private TsAuthManager mgr = new TsAuthManager();
	private Text txtAuthNum;
	private Text txtNt;
	private TsAuthMgtDTO dto;
	private Text txtCustNm;
	private Text txtCustTel;
	{
		// Register as a resource user - SWTResourceManager will
		// handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite
	 * inside a new Shell.
	 */
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		AuthMgtEditComposite inst = new AuthMgtEditComposite(shell, SWT.NULL);

		Point size = inst.getSize();
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AuthMgtEditComposite(org.eclipse.swt.widgets.Composite parent,
			int style) {
		super(parent, style);
		setBackground(ColorRepository.getColor(ColorRepository.BG_CONTENTS));
		initGUI();
		init();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();

			thisLayout.numColumns = 1;
			this.setLayout(thisLayout);
			this.setBackgroundMode(1);
			{
				cptHeader = new Composite(this, SWT.NONE);
				GridLayout cptHeaderLayout = new GridLayout();
				cptHeaderLayout.numColumns = 2;
				cptHeaderLayout.horizontalSpacing = 10;
				cptHeaderLayout.marginHeight = 0;
				cptHeaderLayout.marginBottom = 0;
				cptHeaderLayout.marginTop = 0;
				cptHeader.setLayout(cptHeaderLayout);

				// cptButtonLData.horizontalAlignment =
				cptHeader.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
				{
					final CLabel titleCLabel = new CLabel(cptHeader, SWT.NONE);
					GridData titleLData = new GridData();
					titleLData.verticalAlignment = GridData.BEGINNING;
					titleCLabel.setLayoutData(titleLData);
				}
				{
					cptButton = new Composite(cptHeader, SWT.NONE);
					GridLayout cptButtonLayout = new GridLayout();
					cptButtonLayout.marginHeight = 0;
					cptButtonLayout.marginBottom = 0;
					cptButtonLayout.marginTop = 0;
					cptButtonLayout.numColumns = 3;
					cptButton.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP,
							true, false));
					cptButton.setLayout(cptButtonLayout);
					{
						btnSave = new Button(cptButton, SWT.PUSH | SWT.CENTER);
						btnSave.addSelectionListener(new SelectionAdapter() {
							@Override
							public void widgetSelected(SelectionEvent e) {
								btnSaveMouseDown(e);
							}
						});
						btnSave.setText("저장");
						btnSave.setImage(ImageRepository.getImage(ImageRepository.BTN_SAVE));
						btnSave.setLayoutData(new GridData(SWT.FILL,
								SWT.CENTER, true, false));
						btnSave.setFont(defaultLabelFont);
					}
					{
						btnDelete = new Button(cptButton, SWT.PUSH | SWT.CENTER);
						btnDelete.setText("삭제");
						btnDelete.setImage(ImageRepository.getImage(ImageRepository.BTN_DELETE));
						btnDelete.setLayoutData(new GridData(SWT.FILL,
								SWT.CENTER, true, false));
						btnDelete.setFont(defaultLabelFont);
						btnDelete.addMouseListener(new MouseAdapter() {
							public void mouseDown(MouseEvent evt) {
								btnDeleteMouseDown(evt);
							}
						});
					}
					{
						btnClear = new Button(cptButton, SWT.PUSH | SWT.CENTER);
						btnClear.setText("초기화");
						btnClear.setImage(ImageRepository.getImage(ImageRepository.BTN_CLEAR));
						btnClear.setLayoutData(new GridData(SWT.FILL,
								SWT.CENTER, true, false));
						btnClear.setFont(defaultLabelFont);
						btnClear.addMouseListener(new MouseAdapter() {
							public void mouseDown(MouseEvent evt) {
								btnClearMouseDown(evt);
							}
						});
					}
				}
			}
			{
				round = new RoundImageComposite(this, SWT.NONE);
				round.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				
				GridLayout cptBodyLayout = new GridLayout();
				cptBodyLayout.numColumns = 2;
				GridData cptBodyLData = new GridData();
				cptBodyLData.horizontalIndent = 15;
				cptBodyLData.horizontalAlignment = GridData.FILL;
				cptBodyLData.grabExcessHorizontalSpace = true;
				cptBodyLData.grabExcessVerticalSpace = true;
				cptBodyLData.verticalAlignment = GridData.CENTER;
				round.getControl().setLayout(cptBodyLayout);
				{
					final CLabel lblTag = new CLabel(round.getControl(), SWT.RIGHT);
					lblTag.setText("인증 Key: ");
					lblTag.setImage(ImageRepository.getImage(ImageRepository.DOT_SELECT));
					lblTag.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					lblTag.setFont(defaultLabelFont);
				}
				{
					txtAuthKey = new Text(round.getControl(), SWT.BORDER);
					txtAuthKey.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							if(txtAuthKey.getText().replaceAll("-","").length()==12){
								genSerial();
							}else{
								txtAuthNum.setText("");
							}
						}
						@Override
						public void keyPressed(KeyEvent e) {
							if( StringUtil.isHangle(e.character) ){
								e.doit = false;
							}
						}
					});
					txtAuthKey.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					txtAuthKey.setFont(defaultInputFont);
					txtAuthKey.setTextLimit(14);
				}
				
				{
					final CLabel lblTag = new CLabel(round.getControl(), SWT.RIGHT);
					lblTag.setText("인증번호: ");
					lblTag.setImage(ImageRepository.getImage(ImageRepository.DOT_SELECT));
					lblTag.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					lblTag.setFont(defaultLabelFont);
				}
				{
					txtAuthNum = new Text(round.getControl(), SWT.BORDER);
					txtAuthNum.setEditable(false);
					txtAuthNum.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					txtAuthNum.setFont(defaultInputFont);
					txtAuthNum.setTextLimit(15);
					txtAuthNum.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.keyCode == 0x0D){
								((Text)e.widget).traverse(SWT.TRAVERSE_TAB_NEXT);
							}
						}
					});
				}
				{
					final CLabel lblTag = new CLabel(round.getControl(), SWT.RIGHT);
					lblTag.setText("거래처명: ");
					lblTag.setImage(ImageRepository.getImage(ImageRepository.DOT_SELECT));
					lblTag.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					lblTag.setFont(defaultLabelFont);
				}
				{
					txtCustNm = new Text(round.getControl(), SWT.BORDER);
					txtCustNm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					txtCustNm.setFont(defaultInputFont);
					txtCustNm.setTextLimit(25);
					txtCustNm.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.keyCode == 0x0D){
								btnSave.setFocus();
							}
						}
					});
				}
				{
					final CLabel lblTag = new CLabel(round.getControl(), SWT.RIGHT);
					lblTag.setText("연락처: ");
					lblTag.setImage(ImageRepository.getImage(ImageRepository.DOT_SELECT));
					lblTag.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					lblTag.setFont(defaultLabelFont);
				}
				{
					txtCustTel = new Text(round.getControl(), SWT.BORDER);
					txtCustTel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					txtCustTel.setFont(defaultInputFont);
					txtCustTel.setTextLimit(25);
					txtCustTel.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.keyCode == 0x0D){
								btnSave.setFocus();
							}
						}
					});
				}
				{
					final CLabel lblTag = new CLabel(round.getControl(), SWT.RIGHT);
					lblTag.setText("비 고: ");
					lblTag.setImage(ImageRepository.getImage(ImageRepository.DOT_SELECT));
					lblTag.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
					lblTag.setFont(defaultLabelFont);
				}
				{
					txtNt = new Text(round.getControl(), SWT.BORDER);
					txtNt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					txtNt.setFont(defaultInputFont);
					txtNt.setTextLimit(25);
					txtNt.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							if(e.keyCode == 0x0D){
								btnSave.setFocus();
							}
						}
					});
				}
			}

			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void genSerial() {
	    txtAuthNum.setText(AuthUtil.genSerial(txtAuthKey.getText().replaceAll("-", "").toUpperCase()));
    }

	/**
	 * 초기화
	 */
	private void init() {
		
	}

	private void btnSaveMouseDown(SelectionEvent evt) {
		if(!validate())
			return;
		
		if(MessageDialog.openConfirm(getShell(), "저장확인", "데이터를 저장하시겠습니까?")){
			try{
				// 저장처리
				TsAuthMgtDTO pdto = (TsAuthMgtDTO)ObjectUtil.getDefaultObject(TsAuthMgtDTO.class.getName());
				pdto.setAuth_key(txtAuthKey.getText());
				pdto.setAuth_num(txtAuthNum.getText());
				pdto.setCst_nm(txtCustNm.getText());
				pdto.setCst_tel(txtCustTel.getText());
				pdto.setNt(txtNt.getText().trim());
				
				// 등록
				if(dto == null){
					pdto.setAuth_seq(mgr.selectTsAuthMgtKey());
					mgr.insertTsAuthMgt(pdto);
				}else{
				// 수정
					pdto.setAuth_seq(dto.getAuth_seq());
					pdto.setRgn_dt(null);
					pdto.setRgn_id(null);
					mgr.updateTsAuthMgt(pdto);
				}
				
				callback.callback(CallbackIF.CMD_LIST, null);
				MessageDialog.openInformation(getShell(), "저장완료", "정상적으로 처리되었습니다.");
				btnClearMouseDown(null);
			}catch(Exception e){
				MessageDialog.openError(getShell(), "저장 오류 Error", e.getMessage());
				e.printStackTrace();
				log.error(e.getMessage());
			}
		}
	}

	private boolean validate() {
		if(txtAuthKey.getText().trim().length() != 14){
			MessageDialog.openWarning(getShell(), "인증키 오류", "인증키를 입력하세요.");
			txtAuthKey.setFocus();
			return false;
		}
		if("".equals(txtAuthNum.getText().trim())){
			MessageDialog.openWarning(getShell(), "인증번호", "인증번호가 생성되지 않았습니다. 인증키를 입력하세요.");
			txtAuthKey.setFocus();
			return false;
		}
		if("".equals(txtCustNm.getText().trim())){
			MessageDialog.openWarning(getShell(), "거래처명", "거래처명을 입력하세요.");
			txtCustNm.setFocus();
			return false;
		}
		
	    return true;
    }

	private void btnDeleteMouseDown(MouseEvent evt) {
		try{
			if(dto == null){
				this.btnClearMouseDown(null);
				return;
			}
			if(MessageDialog.openConfirm(getShell(), "삭제확인", "데이터를 삭제하시겠습니까?")){
				dto = (TsAuthMgtDTO)ObjectUtil.getUpdateObject(dto);
				mgr.deleteTsAuthMgt(dto);
				callback.callback(CallbackIF.CMD_LIST, null);
				btnClearMouseDown(null);
				MessageDialog.openInformation(getShell(), "삭제완료", "데이터가 삭제되었습니다.");
			}
		}catch(Exception e){
			MessageDialog.openError(getShell(), "삭제 Error", e.getMessage());
			log.error(e.getMessage());
		}
	}

	private void btnClearMouseDown(MouseEvent evt) {
		dto = null;
		this.txtAuthKey.setText("");
		this.txtAuthNum.setText("");
		this.txtNt.setText("");
		this.txtCustNm.setText("");
		this.txtCustTel.setText("");
	}

	@Override
	public void callback(String cmd, Object obj) {
		btnClearMouseDown(null);
		dto = (TsAuthMgtDTO)obj;
		select();
	}

	private void select() {
		ArrayList<TsAuthMgtDTO> list = null;
        try {
	        list = mgr.selectTsAuthMgt(dto);
        } catch (Exception e) {
	        e.printStackTrace();
        }
		if(list == null || list.size()==0){
			MessageDialog.openWarning(getShell(), "조회결과", "조회된 데이터가 없습니다.");
			return;
		}
		dto = list.get(0);
		this.txtAuthKey.setText(StringUtil.nullToBlank(dto.getAuth_key()));
		this.txtAuthNum.setText(StringUtil.nullToBlank(dto.getAuth_num()));
		this.txtCustNm.setText(StringUtil.nullToBlank(dto.getCst_nm()));
		this.txtCustTel.setText(StringUtil.nullToBlank(dto.getCst_tel()));
		this.txtNt.setText(StringUtil.nullToBlank(dto.getNt()));
		txtAuthKey.setFocus();
    }

	@Override
	public void addCallback(CallbackIF callback) {
		this.callback = callback;
	}
}