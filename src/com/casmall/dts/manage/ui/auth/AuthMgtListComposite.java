package com.casmall.dts.manage.ui.auth;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.jface.gridviewer.GridViewerEditor;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.casmall.common.StringUtil;
import com.casmall.dts.common.ColorRepository;
import com.casmall.dts.common.ExportVO;
import com.casmall.dts.common.ImageRepository;
import com.casmall.dts.common.RvExcelWriter;
import com.casmall.dts.manage.biz.domain.TsAuthMgtDTO;
import com.casmall.dts.manage.biz.mgr.TsAuthManager;
import com.casmall.dts.ui.common.CallbackIF;
import com.casmall.dts.ui.view.CarMgtView;
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
public class AuthMgtListComposite extends Composite implements CallbackIF{

	protected static Log log = LogFactory.getLog(AuthMgtListComposite.class);
	private Button btnSelect;
	private Composite ctTop;
	private Composite ctSelect;

	private GridTableViewer gridViewer;
	private String[] colProp = { "auth_seq", "no", "cst_nm", "cst_tel", "auth_key", "nt"};
	private String[] colName = { "", "No", "�ŷ�ó��", "����ó", "����Key", "���"};
	private int[] colWidth = { 0, 8, 17, 25, 22, 28};
	private int[] colAlign = { SWT.NONE, SWT.CENTER, SWT.LEFT, SWT.LEFT, SWT.CENTER, SWT.LEFT};
	private ArrayList<TsAuthMgtDTO> listData;
	private CallbackIF callback;
	
	private Font titleFont = com.swtdesigner.SWTResourceManager.getFont("Arial", 18, SWT.NORMAL);
	private Font defaultFont = com.swtdesigner.SWTResourceManager.getFont("Arial", 14, SWT.NORMAL);
	private TsAuthManager mgr = new TsAuthManager();
	private Text txtSearch;
	
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
		AuthMgtListComposite inst = new AuthMgtListComposite(shell, SWT.NULL);

		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
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

	public AuthMgtListComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		setBackground(ColorRepository.getColor(ColorRepository.BG_CONTENTS));

		initGUI();
		init();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			thisLayout.makeColumnsEqualWidth = true;
			this.setLayout(thisLayout);
			this.setSize(1010, 418);
			{
				final CLabel lblTitle = new CLabel(this, SWT.NONE);
				lblTitle.setText("�������� ����");
				lblTitle.setImage(ImageRepository.getImage(ImageRepository.ICO_SELECT));
				lblTitle.setFont(titleFont);
				lblTitle.setForeground(ColorRepository.getColor(ColorRepository.TEXT_TITLE));
				lblTitle.setBackground(ColorRepository.getColor(ColorRepository.BG_CONTENTS));
				GridData lblTitleLData = new GridData(SWT.FILL, SWT.BOTTOM, false, false);
				lblTitleLData.verticalIndent = 3;
				lblTitleLData.horizontalIndent = 10;
				lblTitle.setLayoutData(lblTitleLData);
			}
			{
				ctSelect = new Composite(this, SWT.NONE);
				ctSelect.setBackgroundMode(SWT.INHERIT_FORCE);
				GridLayout ctSelectLayout = new GridLayout();
				ctSelectLayout.marginLeft = -9;
				ctSelectLayout.marginRight = -9;
				ctSelectLayout.marginWidth = 0;
				ctSelectLayout.verticalSpacing = 0;
				ctSelectLayout.numColumns = 3;
				ctSelectLayout.marginHeight = 0;
				ctSelectLayout.horizontalSpacing = 0;
				GridData ctSelectLData = new GridData(SWT.FILL, SWT.FILL, true, false);
				ctSelectLData.heightHint = 75;
				ctSelect.setLayoutData(ctSelectLData);
				ctSelect.setLayout(ctSelectLayout);

				final Composite ctSelectLeft = new Composite(ctSelect, SWT.NONE);
				ctSelectLeft.setBackgroundImage(ImageRepository.getImage(ImageRepository.BG_SELECT_LEFT));
				ctSelectLeft.setLayout(new GridLayout());
				GridData ctSelectLeftLData = new GridData(SWT.LEFT, SWT.FILL, false, true);
				ctSelectLeftLData.widthHint = 19;
				ctSelectLeft.setLayoutData(ctSelectLeftLData);
				
				ctTop = new Composite(ctSelect, SWT.NONE);
				ctTop.setBackgroundImage(ImageRepository.getImage(ImageRepository.BG_SELECT));
				GridLayout ctTopLayout = new GridLayout();
				ctTopLayout.numColumns = 6;
				GridData ctTopLData = new GridData();
				ctTopLData.grabExcessHorizontalSpace = true;
				ctTopLData.horizontalAlignment = GridData.FILL;
				ctTopLData.grabExcessVerticalSpace = true;
				ctTopLData.verticalAlignment = GridData.FILL;
				ctTop.setLayoutData(ctTopLData);
				ctTop.setLayout(ctTopLayout);
				{
					CLabel lblTag = new CLabel(ctTop, SWT.NONE);
					lblTag.setFont(defaultFont);
					lblTag.setText("�˻���: ");
					GridData lblTermLData = new GridData(SWT.CENTER, SWT.CENTER, false, true);
					lblTag.setImage(ImageRepository.getImage(ImageRepository.DOT_SELECT));
					lblTermLData.heightHint = 17;
					lblTermLData.horizontalIndent = 10;
					lblTag.setLayoutData(lblTermLData);
				}
				{
					txtSearch = new Text(ctTop, SWT.BORDER);
					txtSearch.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							if(e.keyCode == 0x0D){
								selectData();
							}
						}
					});
					GridData gd_txtMgtCd = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
					gd_txtMgtCd.widthHint = 40;
					txtSearch.setLayoutData(gd_txtMgtCd);
					txtSearch.setFont(defaultFont);
				}
				{
					btnSelect = new Button(ctTop, SWT.PUSH | SWT.CENTER);
					GridData btnSelectLData = new GridData();
					btnSelectLData.grabExcessHorizontalSpace = true;
					btnSelectLData.horizontalAlignment = GridData.END;
					btnSelect.setLayoutData(btnSelectLData);
					btnSelect.setImage(ImageRepository.getImage(ImageRepository.BTN_SELECT));
					btnSelect.setFont(defaultFont);
					btnSelect.setText("�˻�");
					btnSelect.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
							btnSelectMouseDown(evt);
						}
					});	
				}
				{
					Button btnExport = new Button(ctTop, SWT.PUSH | SWT.CENTER);
					GridData btnSelectLData = new GridData();
					btnSelectLData.grabExcessHorizontalSpace = false;
					btnSelectLData.horizontalAlignment = GridData.END;
					btnExport.setLayoutData(btnSelectLData);
					btnExport.setImage(ImageRepository.getImage(ImageRepository.BTN_EXPORT));
					btnExport.setFont(defaultFont);
					btnExport.setText("��������");
					btnExport.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
							btnExportMouseDown(evt);
						}
					});	
				}
				{
					Button btnClose = new Button(ctTop, SWT.PUSH | SWT.CENTER);
					GridData btnSelectLData = new GridData();
					btnSelectLData.grabExcessHorizontalSpace = false;
					btnSelectLData.horizontalAlignment = GridData.END;
					btnClose.setLayoutData(btnSelectLData);
					btnClose.setImage(ImageRepository.getImage(ImageRepository.BTN_CLOSE));
					btnClose.setFont(defaultFont);
					btnClose.setText("�ݱ�");
					btnClose.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent evt) {
							IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
							IViewReference ref = page.findViewReference(CarMgtView.ID);
							page.hideView(ref);
						}
					});	
				}
				final Composite ctSelectRight = new Composite(ctSelect, SWT.NONE);
				ctSelectRight.setBackgroundImage(ImageRepository.getImage(ImageRepository.BG_SELECT_RIGHT));
				ctSelectRight.setLayout(new GridLayout());
				GridData ctSelectRightLData = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
				ctSelectRightLData.widthHint = 19;
				ctSelectRight.setLayoutData(ctSelectRightLData);

			}
			{
				gridViewer = new GridTableViewer(this, SWT.BORDER|SWT.V_SCROLL);
				gridViewer.setLabelProvider(new ListGridLabelProvider());
				gridViewer.setContentProvider(new ListGridContentProvider());
				gridViewer.getGrid().setSelectionEnabled(true);
				gridViewer.getGrid().setFont(defaultFont);
				gridViewer.getGrid().setItemHeight(28);
				gridViewer.setCellEditors(new CellEditor[] { new TextCellEditor(gridViewer.getGrid()),
						new TextCellEditor(gridViewer.getGrid()) });
				gridViewer.setCellModifier(new ICellModifier() {
					public boolean canModify(Object element, String property) {
						return false;
					}

					public Object getValue(Object element, String property) {
						return element.toString();
					}

					public void modify(Object element, String property, Object value) {

					}
				});
				gridViewer.setColumnProperties(colProp);
				ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(gridViewer) {
					protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
						return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
								|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
								|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR);
					}
				};
				GridViewerEditor.create(gridViewer, actSupport, ColumnViewerEditor.TABBING_HORIZONTAL
						| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR | ColumnViewerEditor.TABBING_VERTICAL
						| ColumnViewerEditor.KEYBOARD_ACTIVATION);
				for (int i = 0; i < colName.length; i++) {
					GridColumn column = new GridColumn(gridViewer.getGrid(), SWT.NONE);
					column.setWidth(colWidth[i]*10);
					column.setAlignment(colAlign[i] );
					column.setText(colName[i]);
					column.setResizeable(false);
				}
				gridViewer.getGrid().setLinesVisible(true);
				gridViewer.getGrid().setHeaderVisible(true);
				gridViewer.getGrid().addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						Grid g = (Grid)evt.getSource();
						if(listData!=null && listData.size()>g.getSelectionIndex() && g.getSelectionIndex() != -1){
							TsAuthMgtDTO vo = listData.get(g.getSelectionIndex());
							callback.callback(CallbackIF.CMD_EDIT, vo);
						}
					}
				});
				
				Grid grid = gridViewer.getGrid();
				grid.addControlListener(new ControlAdapter() {
					@Override
					public void controlResized(ControlEvent e) {
						int width = 0;
						for(int i=0;i<gridViewer.getGrid().getColumnCount();i++){
							width = (int)(colWidth[i]*gridViewer.getGrid().getClientArea().width/100);
							if(i==gridViewer.getGrid().getColumnCount()-1){
								width+=5;
							}
							gridViewer.getGrid().getColumn(i).setWidth(width);
						}
						int add = gridViewer.getGrid().getBounds().width/100 - 7;
						gridViewer.getGrid().setFont(SWTResourceManager.getFont("Arial", 10 + (add>0?add:0), SWT.NORMAL));
					}
				});
				grid.setLineColor(ColorRepository.getColor(ColorRepository.GRID_LINE));
				GridData gridViewerLData = new GridData();
				gridViewerLData.grabExcessHorizontalSpace = true;
				gridViewerLData.horizontalAlignment = GridData.FILL;
				gridViewerLData.grabExcessVerticalSpace = true;
				gridViewerLData.verticalAlignment = GridData.FILL;
				gridViewer.getGrid().setLayoutData(gridViewerLData);
			}

			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init(){
		gridViewer.getGrid().setLineColor(ColorRepository.getColor(ColorRepository.GRID_LINE));
		txtSearch.setFocus();
	}

	public class ListGridLabelProvider extends LabelProvider implements ITableLabelProvider, ITableFontProvider,
			ITableColorProvider {
		FontRegistry registry = new FontRegistry();

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			TsAuthMgtDTO data = (TsAuthMgtDTO) element;
			Object o = StringUtil.invoke(data, StringUtil.makeGetter(colProp[columnIndex]),null);
			if("no".equals(colProp[columnIndex])){
				return ""+(listData.indexOf(data)+1);
			}
			return StringUtil.extractString(o,0);
		}

		public Font getFont(Object element, int columnIndex) {
			return null;
		}

		public Color getBackground(Object element, int columnIndex) {
			TsAuthMgtDTO data = (TsAuthMgtDTO) element;
			if (listData.indexOf(data) % 2 == 0) {
				return ColorRepository.getColor(ColorRepository.GRID_ODD_BG);
			}
			return null;
		}

		public Color getForeground(Object element, int columnIndex) {
			TsAuthMgtDTO data = (TsAuthMgtDTO) element;
			if (listData.indexOf(data) % 2 == 0) {
				return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE);
			}
			return null;
		}
	}

	private class ListGridContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		public void dispose() {

		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	/**
	 * ��ȸ��ư Ŭ�� �Լ�
	 * @param evt
	 */
	private void btnSelectMouseDown(MouseEvent evt) {
		selectData();
		if (listData == null || listData.size() == 0) {
			MessageDialog.openInformation(getShell(), "������ ��ȸ", "��ȸ�� �����Ͱ� �����ϴ�..");
		}
	}
	
	/**
	 * ������ ��ȸ
	 */
	private void selectData(){
		try{
			TsAuthMgtDTO dto = new TsAuthMgtDTO();
			if(!"".equals(txtSearch.getText().trim()))
				dto.setSearch(txtSearch.getText().trim());
			listData = mgr.selectTsAuthMgt(dto);
			Object[] objs = listData.toArray(new Object[0]);
			gridViewer.setInput(objs);
		}catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
			MessageDialog.openError(getShell(), "��ȸ���� Error", e.getMessage());
		}
	}
	
	private void btnExportMouseDown(MouseEvent evt){
		if(listData == null){
			MessageDialog.openInformation(this.getShell(), "��������", "�������Ϸ� �����Ͻðڽ��ϱ�?");
			return;
		}
		FileDialog dialog = new FileDialog(this.getShell(), SWT.SAVE);
	    dialog.setFilterNames(new String[] { "Excel Files", "All Files (*.*)" });
	    dialog.setFilterExtensions(new String[] { "*.xls", "*.*"});
	    dialog.setFileName("AuthMgt.xls");
	    String saveFile = dialog.open();
	    if (saveFile == null) {
			return;
		}
	    saveExport(saveFile, "������ȣ ����");
	}
	
	/**
	 * Excel ���� ����
	 * @param saveFile
	 */
	private void saveExport(String saveFile, String... str) {
		
		RvExcelWriter w = new RvExcelWriter(saveFile);

		ExportVO export = new ExportVO();
		export.setWidth(colWidth);
		export.setTitle(str[0]);
		export.setHeader(colName);
		if(str.length>1)
		export.setCond(str[1]);
		export.setData(listData.toArray(), colProp);

		try {
			w.write(export);
			MessageDialog.openInformation(this.getShell(), "��������", "�������Ϸ� ����Ǿ����ϴ�.");
		} catch (IOException e) {
			MessageDialog.openError(this.getShell(), "Export Fail", "[Error] �������� ���� �� ������ �߻��Ͽ����ϴ�.\n\n"+e.getMessage());
		}
	}

	public void addCallback(CallbackIF callback){
		this.callback = callback;
	}

	@Override
	public void callback(String cmd, Object obj) {
		selectData();
	}
}
