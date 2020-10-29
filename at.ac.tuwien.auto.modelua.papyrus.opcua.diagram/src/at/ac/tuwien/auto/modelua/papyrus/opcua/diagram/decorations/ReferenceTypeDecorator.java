package at.ac.tuwien.auto.modelua.papyrus.opcua.diagram.decorations;

import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;

public class ReferenceTypeDecorator extends PolygonDecoration  {
	/** Default X scale value. */
	private static final int DEFAULT_SCALE_X = 15;

	/** Default Y scale value. */
	private static final int DEFAULT_SCALE_Y = 5;
	
	public static final PointList TIP = new PointList();
	
	static {
		TIP.addPoint(0, 0);
		TIP.addPoint(-1, 1);
		TIP.addPoint(-1, -1);
	}
	
	/**
	 * Constructor.
	 */
	public ReferenceTypeDecorator() {
		init();
	}

	/**
	 * Initialize the decoration.
	 */
	protected void init() {
		setTemplate(TIP);
		setScale(DEFAULT_SCALE_X, DEFAULT_SCALE_Y);
	}

	/**
	 * <pre>
	 * Overridden to take into account of the line with in the scale (better representation).
	 * </pre>
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.draw2d.Polyline#setLineWidth(int)
	 */
	@Override
	public void setLineWidth(final int w) {
		setScale(DEFAULT_SCALE_X + w, DEFAULT_SCALE_Y + w);
		super.setLineWidth(w);
	}
}
