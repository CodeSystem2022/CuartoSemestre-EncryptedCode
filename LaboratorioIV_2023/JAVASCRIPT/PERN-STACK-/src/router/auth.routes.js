import { Router } from "express";
import { signin, signup, signoup, profile } from "../controllers/auth.controllers";

const router = Router();

router.post("/signin", signin);

router.post("/signup", signup);

router.post("/signoup",signoup);

router.get("/profile", profile);

export default router;