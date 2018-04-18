package org.geogebra.common.geogebra3D.euclidian3D.openGL;

import java.util.ArrayList;
import java.util.List;

import org.geogebra.common.geogebra3D.euclidian3D.openGL.ManagerShaders.TypeElement;
import org.geogebra.common.kernel.Matrix.Coords;

/**
 * manager for packing buffers (for curves)
 */
public class GLBufferManagerTemplatesForPoints extends GLBufferManager {

	// we don't use buffers here
	static final private int ELEMENTS_SIZE_START = 0;
	static final private int INDICES_SIZE_START = 0;

	private GLBufferIndicesArray bufferIndicesArray;

	private ArrayList<Double>[] vertexTemplates, normalTemplates;
	private ArrayList<Short>[] indicesTemplates;

	private ArrayList<Double> currentVertexArray, currentNormalArray;
	private ArrayList<Short> currentIndicesArray;

	// private ArrayList<Short>

	/**
	 * constructor
	 */
	@SuppressWarnings("unchecked")
	public GLBufferManagerTemplatesForPoints() {
		vertexTemplates = new ArrayList[ManagerShadersWithTemplates.POINT_TEMPLATES_COUNT];
		normalTemplates = new ArrayList[ManagerShadersWithTemplates.POINT_TEMPLATES_COUNT];
		indicesTemplates = new ArrayList[ManagerShadersWithTemplates.POINT_TEMPLATES_COUNT];
	}

	@Override
	protected int calculateIndicesLength(int size, TypeElement type) {
		// not used
		return size;
	}

	@Override
	protected void putIndices(int size, TypeElement type,
			boolean reuseSegment) {
		// not used
	}

	/**
	 * draw
	 * 
	 * @param r
	 *            renderer
	 */
	public void draw(RendererShadersInterface r) {
		drawBufferPacks(r);
	}

	@Override
	protected int getElementSizeStart() {
		return ELEMENTS_SIZE_START;
	}

	@Override
	protected int getIndicesSizeStart() {
		return INDICES_SIZE_START;
	}

	/**
	 * 
	 * @return new indices array
	 */
	public GLBufferIndicesArray getBufferIndicesArray() {
		bufferIndicesArray = new GLBufferIndicesArray();
		return bufferIndicesArray;
	}

	/**
	 * 
	 * @return current indices array
	 */
	public List<Short> getCurrentIndicesArray() {
		return currentIndicesArray;
	}

	@Override
	public void setIndices(int size, TypeElement type) {
		// not used
	}

	@Override
	public boolean isTemplateForPoints() {
		return true;
	}

	/**
	 * 
	 * @param manager
	 *            manager
	 * @param pointSize
	 *            point size
	 */
	public void createSphereIfNeeded(
			ManagerShadersElementsGlobalBufferPacking manager,
			int pointSize) {

		int templateIndex = ManagerShadersWithTemplates
				.getIndexForPointSize(pointSize);

		currentVertexArray = vertexTemplates[templateIndex];
		if (currentVertexArray == null) {
			createSphere(manager, templateIndex);
		}
	}

	private void createSphere(ManagerShadersElementsGlobalBufferPacking manager,
			int templateIndex) {

		manager.setScalerIdentity();
		manager.drawSphere(ManagerShadersWithTemplates
				.getSphereSizeForIndex(templateIndex), Coords.O, 1d, -1);
		manager.setScalerView();

		currentVertexArray = new ArrayList<>();
		for (int i = 0; i < elementsLength * 3; i++) {
			currentVertexArray.add(vertexArray.get(i));
		}
		vertexTemplates[templateIndex] = currentVertexArray;

		currentNormalArray = new ArrayList<>();
		for (int i = 0; i < elementsLength * 3; i++) {
			currentNormalArray.add(normalArray.get(i));
		}
		normalTemplates[templateIndex] = currentNormalArray;

		currentIndicesArray = new ArrayList<>();
		currentIndicesArray.addAll(bufferIndicesArray);
		indicesTemplates[templateIndex] = currentIndicesArray;

		vertexArray = null;
		normalArray = null;
		bufferIndicesArray = null;
	}

	/**
	 * select template according to point size
	 * 
	 * @param manager
	 *            manager
	 * @param pointSize
	 *            point size
	 */
	public void selectSphereAndCreateIfNeeded(ManagerShadersElementsGlobalBufferPacking manager,
			int pointSize) {

		int templateIndex = ManagerShadersWithTemplates
				.getIndexForPointSize(pointSize);
		currentVertexArray = vertexTemplates[templateIndex];
		if (currentVertexArray == null) {
			createSphere(manager, templateIndex);
		} else {
			elementsLength = currentVertexArray.size() / 3;
			currentNormalArray = normalTemplates[templateIndex];
			currentIndicesArray = indicesTemplates[templateIndex];
		}
	}

	/**
	 * select sphere corresponding to point size. WARNING: geometries must have
	 * been created first
	 * 
	 * @param pointSize
	 *            point size
	 */
	public void selectSphere(int pointSize) {
		int templateIndex = ManagerShadersWithTemplates
				.getIndexForPointSize(pointSize);
		currentVertexArray = vertexTemplates[templateIndex];
		elementsLength = currentVertexArray.size() / 3;
		currentNormalArray = normalTemplates[templateIndex];
		currentIndicesArray = indicesTemplates[templateIndex];
	}

	/**
	 * draw current sphere
	 * 
	 * @param manager
	 *            manager
	 */
	public void drawSphere(ManagerShadersElementsGlobalBufferPacking manager) {
		manager.startGeometry(Manager.Type.TRIANGLES);
		manager.endGeometry(currentIndicesArray.size(), elementsLength,
				currentVertexArray, currentNormalArray);
		manager.endList();
	}

}
