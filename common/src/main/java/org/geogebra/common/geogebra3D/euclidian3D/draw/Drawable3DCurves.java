package org.geogebra.common.geogebra3D.euclidian3D.draw;

import org.geogebra.common.geogebra3D.euclidian3D.EuclidianView3D;
import org.geogebra.common.geogebra3D.euclidian3D.openGL.Renderer;
import org.geogebra.common.geogebra3D.euclidian3D.openGL.Renderer.PickingType;
import org.geogebra.common.kernel.geos.GProperty;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.main.Feature;

/**
 * 
 * @author ggb3D
 *
 *         for "solid" drawables, like lines, segments, etc. these are drawable
 *         that are not to become transparent
 *
 */

public abstract class Drawable3DCurves extends Drawable3D {

	/**
	 * common constructor
	 * 
	 * @param a_view3d
	 * @param a_geo
	 */
	public Drawable3DCurves(EuclidianView3D a_view3d, GeoElement a_geo) {
		super(a_view3d, a_geo);
		setPickingType(PickingType.POINT_OR_CURVE);
	}

	/**
	 * constructor for previewables
	 * 
	 * @param a_view3d
	 *            3D view
	 */
	public Drawable3DCurves(EuclidianView3D a_view3d) {
		super(a_view3d);
		setPickingType(PickingType.POINT_OR_CURVE);
	}

	@Override
	public void drawOutline(Renderer renderer) {

		if (isVisible()) {

			setHighlightingColor();

			renderer.getTextures()
					.setDashFromLineType(getGeoElement().getLineType());
			drawGeometry(renderer);
		}

		drawTracesOutline(renderer, false);

	}

	// ///////////////////////////////////////
	// DRAWING GEOMETRIES

	@Override
	public void drawGeometryHidden(Renderer renderer) {

		drawGeometry(renderer);
	}

	@Override
	public void drawHidden(Renderer renderer) {
		super.drawHidden(renderer);

		drawTracesOutline(renderer, true);

	}


	@Override
	public void drawHiding(Renderer renderer) {
		// method not used for solid drawables
	}

	@Override
	public void drawTransp(Renderer renderer) {
		// methods not used for solid drawables
	}

	@Override
	public void drawNotTransparentSurface(Renderer renderer) {
		// methods not used for solid drawables
	}

	@Override
	public boolean isTransparent() {
		return false;
	}

	@Override
	public void addToDrawable3DLists(Drawable3DLists lists) {
		addToDrawable3DLists(lists, DRAW_TYPE_CURVES);
	}

	@Override
	public void removeFromDrawable3DLists(Drawable3DLists lists) {
		removeFromDrawable3DLists(lists, DRAW_TYPE_CURVES);
	}

	@Override
	protected double getColorShift() {
		return COLOR_SHIFT_CURVES;
	}

	@Override
	public void setWaitForUpdateVisualStyle(GProperty prop) {
		if (shouldBePacked()) {
			if (prop == GProperty.COLOR || prop == GProperty.HIGHLIGHT) {
				setWaitForUpdateColor();
			} else if (prop == GProperty.VISIBLE) {
				setWaitForUpdateVisibility();
			} else {
				setWaitForUpdateOtherStyles(prop);
			}
		} else {
			setWaitForUpdateOtherStyles(prop);
		}
	}

	private void setWaitForUpdateOtherStyles(GProperty prop) {
		super.setWaitForUpdateVisualStyle(prop);
		if (getView3D().getApplication().has(Feature.MOB_PACK_ALL_CURVES)) {
			if (prop == GProperty.ANGLE_STYLE || prop == GProperty.LINE_STYLE
					|| prop == GProperty.COMBINED
					|| prop == GProperty.POINT_STYLE) {
				// also update for e.g. line width
				setWaitForUpdate();
			}
		} else {
			// also update for e.g. line width
			setWaitForUpdate();
		}
	}

	@Override
	protected void updateForViewVisible() {
		if (!waitForUpdate()) {
			updateForView();
		}
	}

	@Override
	public void disposePreview() {
		if (shouldBePacked()) {
			removePreviewFromGL();
		}
		super.disposePreview();
	}

	@Override
	protected void updateGeometriesVisibility() {
		boolean isVisible = isVisible();
		if (geometriesSetVisible != isVisible) {
			setGeometriesVisibility(isVisible);
		}
	}

	@Override
	public int getReusableSurfaceIndex() {
		if (shouldBePackedForManager()) {
			return addToTracesPackingBuffer(getSurfaceIndex());
		}
		return super.getReusableSurfaceIndex();
	}

	@Override
	protected int getReusableGeometryIndex() {
		if (shouldBePackedForManager()) {
			return addToTracesPackingBuffer(getGeometryIndex());
		}
		return super.getReusableGeometryIndex();
	}

	@Override
	protected void recordTrace() {
		if (!shouldBePackedForManager()) {
			super.recordTrace();
		}
	}

	@Override
	protected void clearTraceForViewChangedByZoomOrTranslate() {
		if (shouldBePackedForManager()) {
			if (tracesPackingBuffer != null) {
				while (!tracesPackingBuffer.isEmpty()) {
					doRemoveGeometryIndex(tracesPackingBuffer.pop());
				}
			}
		} else {
			super.clearTraceForViewChangedByZoomOrTranslate();
		}
	}

	@Override
	protected void updateForViewNotVisible() {
		if (shouldBePacked()) {
			if (getView3D().viewChangedByZoom()) {
				// will be updated if visible again
				setWaitForUpdate();
			}
			updateGeometriesVisibility();
		}
	}

	@Override
	public boolean shouldBePacked() {
		return getView3D().getApplication().has(Feature.MOB_PACK_ALL_CURVES)
				&& !createdByDrawList();
	}

}
