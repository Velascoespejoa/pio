import { useState } from "react";
import { useAuth } from "../context/AuthContext.jsx";

function Logout(){
    const { logout } = useAuth();
    const [error, setError] = useState("");

    const handleSubmit = async (e) =>{
        e.preventDefault();
        setError("");

        try{
            await logout();
        } catch (error){
            setError(error.message);
        }        
    }

    return (
        <form className="nav-item" onSubmit={handleSubmit}>
            <button type="submit">
                Cerrar sesión
            </button>
        </form>      
    )
}

export default Logout