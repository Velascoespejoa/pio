import { useState } from "react";
import { useAuth } from "../context/AuthContext.jsx";
import '../styles/login.css';

function Register({volverLogin}){

    const { register, loading } = useAuth();

    const [nick, setNick] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [name, setName] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {

        e.preventDefault();
        setError("");

        try {
            await register(nick, password, email, name);
        } catch (error) {
            setError(error.message);
        }
    };

    return (
        <div className="login-body">
            <h2>Crear usuario</h2>
            <div className="login-container">
                <form onSubmit={handleSubmit}>

                    <input
                        type="text"
                        placeholder="Nick"
                        value={nick}
                        onChange={(e) => setNick(e.target.value)}
                    />

                    <input
                        type="password"
                        placeholder="Contraseña"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />

                    <input
                        type="text"
                        placeholder="Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />

                    <input
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />

                    <button type="submit" disabled={loading}>
                        {loading ? "Entrando..." : "Login"}
                    </button>
                    <a href="#" onClick={(e) => {
                        e.preventDefault();
                        volverLogin();
                    }}>
                        Volver al login
                    </a>
                    
                    {error && <p>{error}</p>}

                </form>
            </div>
        </div>           
            
    );
}

export default Register;