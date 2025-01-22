import React, { useState, useEffect } from "react";
import { getEnseignants, updateEnseignant ,deleteEnseignant} from "../services/api"; // Assurez-vous que cette fonction updateEnseignant existe.
import AddEnseignant from "./AddEnseignant";

const EnseignantList = () => {
  const [enseignants, setEnseignants] = useState([]);
  const [selectedEnseignant, setSelectedEnseignant] = useState(null);
  const [showAddForm, setShowAddForm] = useState(false);
  
  // Fonction pour récupérer les enseignants au chargement du composant
  useEffect(() => {
    const fetchEnseignants = async () => {
      try {
        const data = await getEnseignants();
        setEnseignants(data);
      } catch (error) {
        console.error("Error fetching enseignants:", error);
      }
    };
    fetchEnseignants();
  }, []);

  // Fonction pour sélectionner un enseignant dans la liste
  const handleRowClick = (enseignant) => {
    setSelectedEnseignant(enseignant);
  };

  // Fonction pour gérer les changements dans les champs de formulaire
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setSelectedEnseignant((prev) => ({ ...prev, [name]: value }));
  };

  // Fonction pour annuler la modification et réinitialiser l'enseignant sélectionné
  const handleCancel = () => {
    setSelectedEnseignant(null);
  };

  // Fonction pour modifier les informations de l'enseignant
  const handleModify = async () => {
    if (window.confirm("Voulez-vous vraiment modifier cet enseignant ?")) {
      try {
        // Effectuer la mise à jour des données
        await updateEnseignant(selectedEnseignant.noEnseignant, selectedEnseignant);

        // Mettre à jour la liste des enseignants dans l'état
        setEnseignants((prevEnseignants) =>
          prevEnseignants.map((enseignant) =>
            enseignant.noEnseignant === selectedEnseignant.noEnseignant
              ? { ...enseignant, ...selectedEnseignant } // Mettre à jour l'enseignant modifié
              : enseignant
          )
        );

        alert("Les informations ont été modifiées avec succès.");
        setSelectedEnseignant(null); // Réinitialiser la sélection après la modification
      } catch (error) {
        console.error("Erreur lors de la modification :", error.response || error);
        alert(
          `Une erreur s'est produite lors de la modification : ${
            error.response?.data?.message || error.message
          }`
        );
      }
    }
  };

   // Fonction pour supprimer un enseignant
   const handleDelete = async (id) => {
    if (window.confirm("Voulez-vous vraiment supprimer cet enseignant ?")) {
      try {
        // Supprimer l'enseignant
        await deleteEnseignant(id);

        // Mettre à jour la liste des enseignants
        setEnseignants((prevEnseignants) =>
          prevEnseignants.filter((enseignant) => enseignant.noEnseignant !== id)
        );
        alert("Enseignant supprimé avec succès.");
      } catch (error) {
        console.error("Erreur lors de la suppression :", error.response || error);
        alert(
          `Une erreur s'est produite lors de la suppression : ${
            error.response?.data?.message || error.message
          }`
        );
      }
    }
  };

  const handleAddSuccess = (newEnseignant) => {
    setEnseignants((prev) => [...prev, newEnseignant]);
  };
  

  return (
    <div className="p-8 bg-gray-50 min-h-screen">
      <h2 className="text-2xl font-semibold text-blue-600 mb-6">
        Liste des Enseignants
      </h2>
      <button
        onClick={() => setShowAddForm(true)}
        className="bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700 mb-4"
      >
        Ajouter un enseignant
      </button>

      {showAddForm && (
        <AddEnseignant
          onAddSuccess={handleAddSuccess}
          onClose={() => setShowAddForm(false)}
        />
      )}
      {enseignants.length > 0 ? (
        <div className="grid grid-cols-2 gap-8">
          <table className="table-auto border-collapse w-full bg-white shadow-md rounded-lg overflow-hidden">
            <thead className="bg-blue-600 text-white">
              <tr>
                <th className="px-4 py-2">Code</th>
                <th className="px-4 py-2">Nom</th>
                <th className="px-4 py-2">Prénom</th>
                <th className="px-4 py-2">Action</th>
              </tr>
            </thead>
            <tbody>
              {enseignants.map((enseignant) => (
                <tr
                  key={enseignant.noEnseignant}
                  onClick={() => handleRowClick(enseignant)}
                  className={`cursor-pointer ${
                    selectedEnseignant?.noEnseignant ===
                    enseignant.noEnseignant
                      ? "bg-blue-200"
                      : "hover:bg-blue-50"
                  }`}
                >
                  <td className="border px-4 py-2">{enseignant.noEnseignant}</td>
                  <td className="border px-4 py-2">{enseignant.nom}</td>
                  <td className="border px-4 py-2">{enseignant.prenom}</td>
                  <td className="border px-4 py-2 text-center">
                    <button
                      onClick={() => handleDelete(enseignant.noEnseignant)}
                      className="bg-red-600 text-white px-4 py-2 rounded-lg hover:bg-red-700"
                    >
                      Supprimer
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>

          {selectedEnseignant && (
            <div className="bg-white shadow-md rounded-lg p-6">
              <h3 className="text-lg font-semibold text-blue-600 mb-4">
                Modifier l'enseignant
              </h3>
              <form>
                <div className="mb-4">
                  <label className="block text-gray-700 font-medium mb-2">
                    Type
                  </label>
                  <select
                    name="type"
                    value={selectedEnseignant.type || ""}
                    onChange={handleInputChange}
                    className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                  >
                    <option value="ENC">ENC</option>
                    <option value="INT">INT</option>
                  </select>
                </div>

                {selectedEnseignant.type === "ENC" ? (
                  <>
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Email
                      </label>
                      <input
                        type="text"
                        name="enc_ubo_email"
                        value={selectedEnseignant.enc_ubo_email || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Téléphone UBO
                      </label>
                      <input
                        type="text"
                        name="enc_ubo_tel"
                        value={selectedEnseignant.enc_ubo_tel || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Téléphone Personnel
                      </label>
                      <input
                        type="text"
                        name="enc_perso_tel"
                        value={selectedEnseignant.enc_perso_tel || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Email Personnel
                      </label>
                      <input
                        type="text"
                        name="enc_perso_email"
                        value={selectedEnseignant.enc_perso_email || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>

                  </>
                ) : (
                  <>
                                      <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Email
                      </label>
                      <input
                        type="text"
                        name="int_prof_email"
                        value={selectedEnseignant.int_prof_email || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Téléphone
                      </label>
                      <input
                        type="text"
                        name="int_prof_tel"
                        value={selectedEnseignant.int_prof_tel || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Portable
                      </label>
                      <input
                        type="text"
                        name="tel_port"
                        value={selectedEnseignant.tel_port || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                  
                    <div className="mb-4">
                      <label className="block text-gray-700 font-medium mb-2">
                        Société
                      </label>
                      <input
                        type="text"
                        name="int_soc_nom"
                        value={selectedEnseignant.int_soc_nom || ""}
                        onChange={handleInputChange}
                        className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                      />
                    </div>
                  </>
                )}
              </form>

              <div className="flex justify-end mt-6">
                <button
                  onClick={handleCancel}
                  className="bg-gray-400 text-white px-4 py-2 rounded-lg mr-4 hover:bg-gray-500"
                >
                  Annuler
                </button>
                <button
                  onClick={handleModify}
                  className="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700"
                >
                  Sauvegarder
                </button>
              </div>
            </div>
          )}
        </div>
      ) : (
        <p className="text-gray-600">Aucun enseignant trouvé.</p>
      )}



      
    </div>





  );
};

export default EnseignantList;
