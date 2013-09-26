package geogebra.web.cas.view;

import geogebra.common.cas.view.CASSubDialog;
import geogebra.common.cas.view.CASView;
import geogebra.common.kernel.geos.GeoCasCell;
import geogebra.common.main.Localization;
import geogebra.web.gui.app.VerticalPanelSmart;
import geogebra.web.main.AppW;

import java.util.List;
import java.util.Vector;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DialogBox.Caption;
import com.google.gwt.user.client.ui.DialogBox.CaptionImpl;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Dialog to substitute expressions in CAS Input.
 * @author balazs.bencze
 *
 */
public class CASSubDialogW extends CASSubDialog implements ClickHandler {
	
	private Button btSub, btEval, btNumeric;
	private VerticalPanelSmart optionPane;
	private ScrollPanel tablePane;
	private HorizontalPanel btPanel;
	
	private DialogBox dialog;
	private CellTable<SubstituteValue> table;
	private SimplePager pager;
	private List<SubstituteValue> list;
	
	private AppW app;
	private CASViewW casView;
	
	private static final int DEFAULT_TABLE_WIDTH = 210;
	private static final int DEFAULT_TABLE_HEIGHT = 240;

	/**
	 * Substitute dialog for CAS.
	 * 
	 * @param casView view
	 * @param prefix
	 *            before selection, not effected by the substitution
	 * @param evalText
	 *            the String which will be substituted
	 * @param postfix
	 *            after selection, not effected by the substitution
	 * @param editRow row to edit
	 */
	public CASSubDialogW(CASViewW casView, String prefix, String evalText, String postfix, int editRow) {
		super(prefix, evalText, postfix, editRow);
		
		this.casView = casView;
		this.app = casView.getApp();
		
		createGUI();
	}

	private void createGUI() {
		Caption caption = new CaptionImpl();
		Localization loc = app.getLocalization();
		caption.setText(loc.getPlain("Substitute") + " - " + loc.getCommand("Row") + " " + (editRow + 1));
		dialog = new DialogBox(true, false, caption);
		dialog.setWidget(optionPane = new VerticalPanelSmart());
		dialog.setAutoHideEnabled(true);

		GeoCasCell cell = casView.getConsoleTable().getGeoCasCell(editRow);
		initData(cell);

		table = new CellTable<SubstituteValue>();
		// do not refresh the headers and footers every time the data is updated
		table.setAutoHeaderRefreshDisabled(true);
		table.setAutoFooterRefreshDisabled(true);
	    
		initData(cell);
		createTableColumns();
		fillTableColumns();

		// buttons
		btEval = new Button(EVAL_SYM);
		btEval.setTitle(loc.getMenuTooltip("Evaluate"));
		btEval.getElement().getStyle().setMargin(3, Style.Unit.PX);
		btEval.addClickHandler(this);
		
		btNumeric = new Button(NUM_SYM);
		btNumeric.setTitle(loc.getMenuTooltip("Numeric"));
		btNumeric.getElement().getStyle().setMargin(3, Style.Unit.PX);
		btNumeric.addClickHandler(this);
		
		btSub = new Button(loc.getPlain(SUB_SYM));
		btSub.setTitle(loc.getMenuTooltip("Substitute"));
		btSub.getElement().getStyle().setMargin(3, Style.Unit.PX);
		btSub.addClickHandler(this);
		
		btPanel = new HorizontalPanel();
		
		tablePane = new ScrollPanel(table);
		tablePane.setWidth(DEFAULT_TABLE_WIDTH + "px");
		tablePane.setHeight(DEFAULT_TABLE_HEIGHT + "px");
		
		optionPane.add(tablePane);
		optionPane.add(btPanel);
		
		btPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		btPanel.add(btEval);
		btPanel.add(btNumeric);
		btPanel.add(btSub);
		
		// make this dialog display it
		
    }

	private void fillTableColumns() {
		ListDataProvider<SubstituteValue> dataProvider = new ListDataProvider<CASSubDialog.SubstituteValue>();
		dataProvider.addDataDisplay(table);
		list = dataProvider.getList();
	    for (int i = 0; i < data.size(); i++) {
	    	Vector<String> vec = data.get(i);
	    	list.add(new SubstituteValue(vec.get(0), vec.get(1)));
	    }
	    
    }

	private void createTableColumns() {
		// old expression column
	    Column<SubstituteValue, String> oldVal = new Column<CASSubDialogW.SubstituteValue, String>(new EditTextCell()) {
			@Override
			public String getValue(SubstituteValue object) {
				// TODO Auto-generated method stub
				return object.getVariable();
			}
		};
		table.addColumn(oldVal, app.getPlain("OldExpression"));
		table.setColumnWidth(oldVal, 40, Unit.PX);
		oldVal.setFieldUpdater(new FieldUpdater<CASSubDialog.SubstituteValue, String>() {
			public void update(int index, SubstituteValue object, String value) {
				object.setVariable(value);
			}
		});
		
		Column<SubstituteValue, String> newVal = new Column<CASSubDialogW.SubstituteValue, String>(new EditTextCell()) {
			@Override
			public String getValue(SubstituteValue object) {
				return object.getValue();
			}
		};
		table.addColumn(newVal, app.getPlain("NewExpression"));
		table.setColumnWidth(newVal, 40, Unit.PX);
		newVal.setFieldUpdater(new FieldUpdater<CASSubDialog.SubstituteValue, String>() {
			public void update(int index, SubstituteValue object, String value) {
				object.setValue(value);
			}
		});
    }

	@Override
    protected CASView getCASView() {
	    return casView;
    }

	/**
	 * @return dialog
	 */
	public DialogBox getDialog() {
		return dialog;
	}

	public void onClick(ClickEvent event) {
	    Object src = event.getSource();
	    stopEditing();
	    if (btEval == src) {
	    	if (apply("Evaluate")) 
	    		dialog.setVisible(false);
	    } else if (btNumeric == src) {
	    	if (apply("Numeric"))
	    		dialog.setVisible(false);
	    } else if (btSub == src) {
	    	if (apply("Substitute")) 
	    		dialog.setVisible(false);
	    }
    }
	
	private void stopEditing() {
		data.setSize(list.size());
		for(int i = 0; i < list.size(); i++) {
			Vector<String> vec = data.get(i);
			if (vec == null) {
				vec = new Vector<String>(2);
				data.set(i, vec);
			}
			vec.set(0, list.get(i).getVariable());
			vec.set(1, list.get(i).getValue());
		}
	}
}
