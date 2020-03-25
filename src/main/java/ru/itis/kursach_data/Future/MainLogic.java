package ru.itis.kursach_data.Future;

import com.numericalmethod.suanshu.stats.timeseries.linear.univariate.arima.AutoARIMAFit;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.fitting.AbstractCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoint;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.AbstractLeastSquaresOptimizer;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.apache.commons.math3.exception.util.LocalizedFormats.FUNCTION;

public class MainLogic  {
    /**
     * Это тестовый мейн, желательно ничего не стирать
     *
     * @param args
     */

    //SENPAI!

    public static void main(String[] args) {
        /*double[] giveRes ={747126,733873,709995,649035,612045};// необходимый хардкод
        double[] years = {2013,2014,2015,2016,2017};
        double t = 0;
        Collection<WeightedObservedPoint> observations = new ArrayList<>();
        for(int i = 0;i< giveRes.length;i++) {
            WeightedObservedPoint e = new WeightedObservedPoint(1.0, giveRes[i], years[i]);
            observations.add(e);
        }*/
/*        PolynomialCurveFitter state =PolynomialCurveFitter.create(1);
        //state =state.withStartPoint(giveRes);
        state = state.withMaxIterations(20);
        System.out.println(state.getProblem(observations).getObservationSize());
        // creating regression object, passing true to have intercept term*/
        SimpleRegression simpleRegression = new SimpleRegression(true);

        // passing data to the model
        // model will be fitted automatically by the class
        double[][] mass = new double[][]{  // Сюда загрузку данных ввиде двойного массива года-значенич
                {2013, 747126},
                {2014, 733873},
                {2015, 709995},
                {2016, 649035},
                {2017,612045}
        };
        simpleRegression.addData(mass);
       // System.out.println("slope = " + simpleRegression.getSlope());
        //System.out.println("intercept = " + simpleRegression.getIntercept());
        System.out.println(simpleRegression.predict(2018.0));   // predict на 2018 год


    }

    double[][] mass;
    SimpleRegression sr;

    public  double predict(double year){
       return sr.predict(year);
    }

    public MainLogic(double[][] mass) {
        this.mass = mass;
        sr = new SimpleRegression(true);
    }
    public  void addData(double[][] mass){
        sr.addData(mass);
    }
    public void addData(double x, double y){
        sr.addData(x,y);
    }

}
