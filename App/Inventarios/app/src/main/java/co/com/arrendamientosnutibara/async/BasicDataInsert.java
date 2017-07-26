package co.com.arrendamientosnutibara.async;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import co.com.arrendamientosnutibara.application.NutibaraApplication;
import co.com.arrendamientosnutibara.entities.DaoSession;
import co.com.arrendamientosnutibara.entities.Element;
import co.com.arrendamientosnutibara.entities.ElementHasMaterial;
import co.com.arrendamientosnutibara.entities.Material;
import co.com.arrendamientosnutibara.entities.Section;
import co.com.arrendamientosnutibara.entities.Type;
import co.com.arrendamientosnutibara.interfaces.AsyncResult;

/**
 * Created by jva807 on 26/07/2017.
 */

public class BasicDataInsert extends AsyncTask<JSONObject, Void, Boolean>{

    private AsyncResult delegate;

    public BasicDataInsert(AsyncResult delegate){
        this.delegate = delegate;
    }

    @Override
    protected Boolean doInBackground(JSONObject... jsonObjects) {
        JSONObject response = jsonObjects[0];
        try {
            Gson gson = new Gson();

            DaoSession session = NutibaraApplication.getApplicationInstance().getDaoSession();
            JSONObject dataResponse = response.getJSONObject("data");

            JSONArray typesResponse = dataResponse.getJSONArray("types");
            TypeToken<List<Type>> typeToken = new TypeToken<List<Type>>() {
            };
            List<Type> types = gson.fromJson(typesResponse.toString(), typeToken.getType());
            session.getTypeDao().insertOrReplaceInTx(types);

            JSONArray sectionsResponse = dataResponse.getJSONArray("sections");
            TypeToken<List<Section>> sectionToken = new TypeToken<List<Section>>() {
            };
            List<Section> sections = gson.fromJson(sectionsResponse.toString(), sectionToken.getType());
            session.getSectionDao().insertOrReplaceInTx(sections);

            JSONArray elementsResponse = dataResponse.getJSONArray("elements");
            TypeToken<List<Element>> elementToken = new TypeToken<List<Element>>() {
            };
            List<Element> elements = gson.fromJson(elementsResponse.toString(), elementToken.getType());
            session.getElementDao().insertOrReplaceInTx(elements);

            JSONArray materialsResponse = dataResponse.getJSONArray("materials");
            TypeToken<List<Material>> materialToken = new TypeToken<List<Material>>() {
            };
            List<Material> materials = gson.fromJson(materialsResponse.toString(), materialToken.getType());
            session.getMaterialDao().insertOrReplaceInTx(materials);

            JSONArray elementsHasMaterialsResponse = dataResponse.getJSONArray("elements_has_materials");
            TypeToken<List<ElementHasMaterial>> elementHasMaterialToken = new TypeToken<List<ElementHasMaterial>>() {
            };
            List<ElementHasMaterial> elementHasMaterials = gson.fromJson(elementsHasMaterialsResponse.toString(), elementHasMaterialToken.getType());
            session.getElementHasMaterialDao().insertOrReplaceInTx(elementHasMaterials);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        delegate.isSuccessful(result);
    }

}
