import express from "express";
import morgan from "morgan";
import tareasRoutes from "./router/tareas.routes.js"
import authRoutes from "./router/auth.routes.js"
import cookiePaser from "cookie-parser";

const app = express();
//Middlewares
app.use(morgan("dev"));
app.use(cookiePaser());
app.use(express.json());
app.use(express.urlencoded({ extended: false}));

app.get("/", (req, res) => res.json({ message: "Bienvenidos a mi proyecto"}));
app.use(tareasRoutes)
app.use(authRoutes);

//manejando errores
app.use((req, res, next) => {
    res.status(500).json({
        status: "error",
        message: err.messagge
    });
});

export default app;
