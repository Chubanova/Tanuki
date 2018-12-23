package moera.ermais.google.com.tanuki;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;


public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {


        context = params[0].first;

        return null;
    }

    @Override
    protected void onPostExecute(String result) {

    }
}
