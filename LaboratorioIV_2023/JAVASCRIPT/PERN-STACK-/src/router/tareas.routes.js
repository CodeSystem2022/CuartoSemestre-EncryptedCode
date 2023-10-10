import Router from "express-promise-router";
import { listarTareas, listarTare, crearTarea, actualizarTarea, eliminarTarea} from "../controller/tareas.controller.js";

const router = Router();

router.get('/tareas', listarTareas),

router.get('/tareas/:id', listarTare);

router.post('/tareas',crearTarea );

router.put('/tareas/:id',actualizarTarea);

router.delete('/tareas/:id', eliminarTarea)

export default router;