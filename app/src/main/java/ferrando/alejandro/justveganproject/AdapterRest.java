package ferrando.alejandro.justveganproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ferrando.alejandro.justveganproject.model.Restaurant;

public class AdapterRest extends RecyclerView.Adapter<AdapterRest.ViewHolder> {
    private LayoutInflater inflater;
    private View.OnClickListener clicker;
    private List<Restaurant> listRest;
    private Context context;

    public AdapterRest(Context context, List<Restaurant> listRest) {
        this.context = context;
        this.listRest = listRest;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_restaurante, parent, false);
        view.setOnClickListener(clicker);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Restaurant v = listRest.get(position);

        switch (v.getColor()) {
            case "verde":
                viewHolder.imgRest.setColorFilter(ContextCompat.getColor(context, R.color.verde));
                break;
            case "amarillo":
                viewHolder.imgRest.setColorFilter(ContextCompat.getColor(context, R.color.amarillo));
                break;
            case "rojo":
                viewHolder.imgRest.setColorFilter(ContextCompat.getColor(context, R.color.rojo));
                break;
            case "blanco":
                viewHolder.imgRest.setColorFilter(ContextCompat.getColor(context, R.color.gris));
                break;
            case "negro":
                viewHolder.imgRest.setColorFilter(ContextCompat.getColor(context, R.color.grisOscuro));
                break;
            case "azul":
                viewHolder.imgRest.setColorFilter(ContextCompat.getColor(context, R.color.azul));
                break;
        }

        viewHolder.imgRest.setImageResource(R.drawable.baseline_restaurant_menu_24);
        viewHolder.nombre.setText(v.getNombre());
        viewHolder.descripcion.setText(v.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listRest.size();
    }

    public void setOnClickListener(View.OnClickListener click){
        clicker = click;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRest;
        TextView nombre;
        TextView descripcion;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRest = itemView.findViewById(R.id.imgRest);
            nombre = itemView.findViewById(R.id.nombreRest);
            descripcion = itemView.findViewById(R.id.descripcionRestaurante);
            this.view = itemView;
        }

        public void setBack(int position) {
            if (position % 2 != 0) {
                view.setBackgroundColor(context.getResources().getColor(R.color.NaranjaPrincipal));
            } else {
                view.setBackgroundColor(context.getResources().getColor(R.color.NaranjaPrincipalVarianteOs));
            }
        }
    }
}
