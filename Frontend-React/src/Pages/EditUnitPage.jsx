import NavbarComponent from "../components/NavbarComponent"

import { useEffect, useState } from "react";
import {
    BrowserRouter as Router,
    Link,
    Route,
    Routes,
    useParams,
  } from "react-router-dom";
function EditUnitPage() {
    return (
        <>
        <NavbarComponent/>
        <h1>Edit Unit</h1>
        </>
    )
}
export default EditUnitPage