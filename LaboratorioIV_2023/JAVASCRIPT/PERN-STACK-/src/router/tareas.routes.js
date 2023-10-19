import Router from "express-promise-router";
import { listarTareas, listarTare, crearTarea, actualizarTarea, eliminarTarea} from "../controller/tareas.controller.js";
import { isAuth } from "../middlewares/auth.middlewares.js"
const router = Router();

router.get('/tareas',isAuth, listarTareas),

router.get('/tareas/:id',isAuth, listarTare);

router.post('/tareas',isAuth, crearTarea );

router.put('/tareas/:id',isAuth, actualizarTarea);

router.delete('/tareas/:id',isAuth, eliminarTarea)

export default router;
