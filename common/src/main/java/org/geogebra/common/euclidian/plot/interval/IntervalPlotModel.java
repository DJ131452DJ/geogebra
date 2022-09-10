package org.geogebra.common.euclidian.plot.interval;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.geogebra.common.awt.GPoint;
import org.geogebra.common.euclidian.EuclidianView;
import org.geogebra.common.euclidian.plot.TupleNeighbours;
import org.geogebra.common.kernel.geos.GeoFunction;
import org.geogebra.common.kernel.interval.Interval;
import org.geogebra.common.kernel.interval.function.IntervalTuple;
import org.geogebra.common.kernel.interval.function.IntervalTupleList;
import org.geogebra.common.kernel.interval.samplers.IntervalFunctionSampler;

/**
 * Model for Interval plotter.
 *
 * @author laszlo
 */
public class IntervalPlotModel implements QueryFunctionData {
	private final IntervalFunctionData data;
	private final IntervalFunctionSampler sampler;
	private IntervalPath path;
	private final EuclidianViewBounds bounds;
	private boolean resampleNeeded = true;
	/**
	 * Constructor
	 * @param data of the function sampled.
	 * @param sampler to retrieve function data from.
	 * @param bounds {@link EuclidianView}
	 */
	public IntervalPlotModel(IntervalFunctionData data, IntervalFunctionSampler sampler,
			EuclidianViewBounds bounds) {
		this.data = data;
		this.sampler = sampler;
		this.bounds = bounds;
	}

	public void setPath(IntervalPath path) {
		this.path = path;
	}

	/**
	 * Updates what's necessary.
	 */
	public void update() {
		if (resampleNeeded) {
			resample();
		}

		path.update();
	}

	/**
	 * Updates the entire model.
	 */
	public void resample() {
		sampler.resample(bounds.domain());
		resampleNeeded = false;
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	private void updatePath() {
		if (hasValidData()) {
			path.update();
		}
	}

	/**
	 * update function domain to plot due to the visible x range.
	 */
	public void updateDomain() {
		sampler.pan(bounds.domain());
		updatePath();
	}

	/**
	 * Clears the entire model.
	 */
	public void clear() {
		path.reset();
		data.clear();
	}

	GPoint getLabelPoint() {
		return path.getLabelPoint();
	}

	/**
	 *
	 * @param index to get point at
	 * @return corresponding point if index is valid, null otherwise.
	 */
	@Override
	public IntervalTuple at(int index) {
		return data.at(index);
	}

	@Override
	public boolean hasNext(int index) {
		return index < pointCount();
	}

	@Override
	public boolean isInvertedAt(int index) {
		return index >= points().count() || at(index).isInverted();
	}

	private IntervalTupleList points() {
		return data.tuples();
	}

	/**
	 *
	 * @return count of points in model
	 */
	@Override
	public int getCount() {
		return points().count();
	}

	/**
	 *
	 * @param index of the tuple.
	 * @return if the tuple value of a given index is whole or not.
	 */
	@Override
	public boolean isWholeAt(int index) {
		return index >= points().count() || at(index).y().isWhole();
	}

	/**
	 *
	 * @return the number of interval tuples aka points().
	 */
	public int pointCount() {
		return points().count();
	}

	public GeoFunction getGeoFunction() {
		return data.getGeoFunction();
	}

	@Override
	public boolean hasValidData() {
		return points() != null && countDefined() > 1;
	}

	private long countDefined() {
		return points().stream().filter(t -> !t.y().isUndefined()).count();
	}

	private boolean isValidIndex(int index) {
		return index < points().count();
	}

	@Override
	public boolean nonDegenerated(int index) {
		return !isInvertedPositiveInfinity(index);
	}

	private boolean isInvertedPositiveInfinity(int index) {
		return isValidIndex(index)
				&& at(index).y().isPositiveInfinity()
				&& isInvertedAt(index);
	}

	/**
	 * Iterates through and calls the given action on every tuple in model.
	 *
	 * @param action to call on.
	 */
	@Override
	public void forEach(IntConsumer action) {
		Interval xRange = IntervalPlotSettings.visibleXRange();
		if (xRange.isUndefined()) {
			allIndexes().forEach(action);
		} else {
			allIndexes().filter(index -> xRange.contains(at(index).x()))
					.forEach(action);
		}
	}

	private IntStream allIndexes() {
		return IntStream.range(0, pointCount());
	}

	/**
	 * @param index to get the neighbours at.
	 * @return the neighbours around tuple given by index (including itself)
	 */
	@Override
	public TupleNeighbours neighboursAt(int index) {
		return data.neighboursAt(index);
	}

	public void needsResampling() {
		resampleNeeded = true;
	}
}