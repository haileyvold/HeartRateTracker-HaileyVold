package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Tom Gibbons in Feb 2017.
 * For the CIS 3334 class at St. Scholastica
 */

public class HeartRateAdapter  extends ArrayAdapter<HeartRate> {

    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arrayList of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulse);
        tvPulse.setText(hr.getPulse().toString() + " - " + hr.getRangeName().toString() + " - " + hr.getRangeDescription().toString());

        if (hr.getRangeName() == "Red Zone" ) {
            tvPulse.setTextColor(ContextCompat.getColor(context, R.color.colorZone1));
            tvPulse.setTextSize(24);
        }

        else if (hr.getRangeName() == "Anaerobic") {
            tvPulse.setTextColor(ContextCompat.getColor(context, R.color.colorZone2));
            tvPulse.setTextSize(20);
        }

        else if (hr.getRangeName() == "Aerobic") {
            tvPulse.setTextColor(ContextCompat.getColor(context, R.color.colorZone3));
            tvPulse.setTextSize(16);
        }

        else if (hr.getRangeName() == "Endurance") {
            tvPulse.setTextColor(ContextCompat.getColor(context, R.color.colorZone4));
            tvPulse.setTextSize(14);
        }

        else if (hr.getRangeName() == "Moderate") {
            tvPulse.setTextColor(ContextCompat.getColor(context, R.color.colorZone5));
            tvPulse.setTextSize(12);
        }

        if (hr.getRangeName() == "Resting" ) {
            tvPulse.setTextColor(ContextCompat.getColor(context, R.color.colorZone6));
            tvPulse.setTextSize(10);
        }


        return(view);
    }

}
