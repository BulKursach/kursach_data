package ru.itis.kursach_data.Future;

import com.github.signaflo.data.visualization.Plots;
import com.github.signaflo.math.polynomial.interpolation.NewtonPolynomial;
import com.github.signaflo.timeseries.Ts;
import com.github.signaflo.timeseries.model.arima.ArimaCoefficients;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;
import com.github.signaflo.timeseries.model.arima.ArimaProcess;
import com.github.signaflo.timeseries.TestData;
import com.github.signaflo.timeseries.TimeSeries;
import com.github.signaflo.timeseries.forecast.Forecast;
import com.github.signaflo.timeseries.model.Model;
import com.github.signaflo.timeseries.model.arima.Arima;
import com.github.signaflo.timeseries.model.arima.ArimaOrder;
import java.util.Arrays;

//Теперь Фичи проверяем тут (Насчёт прогнозов и тп)
public class FutureLogic {
    public static void main(String[] args) {
        double[][] mass = new double[][]{  // Сюда загрузку данных ввиде двойного массива года-значенич
                {2013, 747126},
                {2014, 733873},
                {2015, 709995},
                {2016, 649035},
                {2017,612045}
        };
        double[] pointmass = new double[]{2013,2016,2014,2017};           // Тестовый вариант (через интерполяцию ньютона) поиска недостающих значений
        double[] valuemass = new double[]{ 747126, 733873, 709995, 649035,612045};


       //TimeSeries timeSeries = TestData.debitcards;
        TimeSeries timeSeries1 = Ts.newAnnualSeries(valuemass);
        ArimaOrder modelOrder = ArimaOrder.order(0,0,1);
        Plots.plot(timeSeries1);
        Arima model = Arima.model(timeSeries1,modelOrder);
        Forecast forecast = model.forecast(7);

        //forecast.pointEstimates().
        System.out.println(Arrays.toString(forecast.pointEstimates().asArray()));
        TimeSeries timeSeries2 = Ts.newAnnualSeries(forecast.pointEstimates().asArray());
        Plots.plot(timeSeries2);
        System.out.println(forecast);
    }
}
