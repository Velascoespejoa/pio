import '../styles/rightbar.css'
import Search from './Search.jsx'


function Rightbar(){

    return (
        <>
            
            <div className="rightbar-container">
                
                <Search />

                <div className="tendencias">
                    <div className="tendencias-title">
                        <span>Tendencias</span>
                    </div>
                    <div className="tendencias-body">
                        <div className="tendencias-item">
                           <div>
                                <span>React</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>Angular</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>NodeJS</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>ExpressJS</span>
                           </div>
                        </div>
                         <div className="tendencias-item">
                           <div>
                                <span>VueJS</span>
                           </div>                  
                        </div>                      
                    </div>
                </div>

                <div className="sugerencias-container">
                    <div className="sugerencias-title">
                        <span>A quién seguir</span>
                    </div>
                    <div className="sugerencias-body">
                        <div className="seguir-a">
                            <div className="seguir-avatar">
                                <img src="http://localhost:8080/uploads/avatars/1.jpeg" alt="img" />
                            </div>

                            <div className="seguir-info">
                                <span className="seguir-nombre">
                                    <strong>Juaniko</strong>
                                </span>

                                <span className="seguir-user">
                                    @juan986
                                </span>
                            </div>

                            <div className="seguir-boton">
                                <button>Seguir</button>
                            </div>
                        </div>

                        <div className="seguir-a">
                            <div className="seguir-avatar">
                                <img src="http://localhost:8080/uploads/avatars/2.jpeg" alt="img" />
                            </div>

                            <div className="seguir-info">
                                <span className="seguir-nombre">
                                    <strong>Rodri Perez velasco</strong>
                                </span>

                                <span className="seguir-user">
                                    @peroz312
                                </span>
                            </div>

                            <div className="seguir-boton">
                                <button>Seguir</button>
                            </div>
                        </div>

                        <div className="seguir-a">
                            <div className="seguir-avatar">
                                <img src="http://localhost:8080/uploads/avatars/3.jpeg" alt="img" />
                            </div>

                            <div className="seguir-info">
                                <span className="seguir-nombre">
                                    <strong>Homero</strong>
                                </span>

                                <span className="seguir-user">
                                    @Illisiaco
                                </span>
                            </div>

                            <div className="seguir-boton">
                                <button>Seguir</button>
                            </div>
                        </div>
                    </div>
                    <div className="sugerencias-footer">

                    </div>
                </div>
            </div>
        </>
    )
    
}

export default Rightbar