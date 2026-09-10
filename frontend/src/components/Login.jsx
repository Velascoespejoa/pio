import { useState } from "react";
import { useAuth } from "../context/AuthContext.jsx";
import '../styles/login.css';
import Register from './Register.jsx';

function Login() {

    const { login, loading } = useAuth();

    const [nick, setNick] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const [mostrarRegister, setMostrarRegister] = useState(false);

    const handleSubmit = async (e) => {

        e.preventDefault();
        setError("");

        try {
            await login(nick, password);
        } catch (error) {
            setError(error.message);
        }
    };

    if (mostrarRegister) {
        return (
            <Register
                volverLogin={() => setMostrarRegister(false)}
            />
        );
}

    return (
        <div className="login-body">
            <h2>Login</h2>
            <div className="login-container">
                <form onSubmit={handleSubmit}>

                    <input
                        type="text"
                        placeholder="Nick"
                        value={nick}
                        onChange={(e) => setNick(e.target.value)}
                        required
                    />

                    <input
                        type="password"
                        placeholder="Contraseña (mínimo 8 caracteres)"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />

                    <button type="submit" disabled={loading}>
                        {loading ? "Entrando..." : "Login"}
                    </button>
                    <a
                        href="#"
                        onClick={(e) => {
                            e.preventDefault();
                            setMostrarRegister(true);
                        }}
                    >
                        Registrarse
                    </a>
                    {error && <p>{error}</p>}

                </form>
            </div>
        </div>
            
            
    );
}

export default Login;