import React, { useState } from "react";
import { addEnseignant } from "../services/api";

const AddEnseignant = ({ onAddSuccess, onClose }) => {
  const [newEnseignant, setNewEnseignant] = useState({
    sexe: "F",
    nom: "",
    prenom: "",
    adresse: "",
    cp: "",
    ville: "",
    pays: "France",
    tel_port: "",
    type: "ENC",
    email: "",
    telephone: "",
    enc_perso_tel: "",
    enc_ubo_tel: "",
    enc_perso_email: "",
    enc_ubo_email: "",
    int_no_insee: "",
    int_soc_nom: "",
    int_soc_adresse: "",
    int_soc_cp: "",
    int_soc_ville: "",
    int_soc_pays: "France",
    int_fonction: "",
    int_prof_email: "",
    int_prof_tel: "",
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewEnseignant((prev) => ({ ...prev, [name]: value }));
  };

  const handleAdd = async () => {
    try {
      const addedEnseignant = await addEnseignant(newEnseignant);
      onAddSuccess(addedEnseignant); // Notifie le parent que l'ajout a réussi
      alert("Enseignant ajouté avec succès !");
      onClose(); // Ferme le formulaire d'ajout
    } catch (error) {
      console.error("Erreur lors de l'ajout :", error.response || error);
      alert(
        `Une erreur s'est produite lors de l'ajout : ${
          error.response?.data?.message || error.message
        }`
      );
    }
  };

  return (
    <div className="bg-white shadow-md rounded-lg p-6">
      <h3 className="text-lg font-semibold text-blue-600 mb-4">
        Ajouter un enseignant
      </h3>
      <form>
      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Sexe</label>
        <select
          name="sexe"
          value={newEnseignant.sexe}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        >
          <option value="F">F</option>
          <option value="M">M</option>
        </select>
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Nom</label>
        <input
          type="text"
          name="nom"
          value={newEnseignant.nom}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Prénom</label>
        <input
          type="text"
          name="prenom"
          value={newEnseignant.prenom}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Adresse</label>
        <input
          type="text"
          name="adresse"
          value={newEnseignant.adresse}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Code Postal</label>
        <input
          type="text"
          name="cp"
          value={newEnseignant.cp}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Ville</label>
        <input
          type="text"
          name="ville"
          value={newEnseignant.ville}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Pays</label>
        <input
          type="text"
          name="pays"
          value={newEnseignant.pays}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>

      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Téléphone Portable</label>
        <input
          type="text"
          name="tel_port"
          value={newEnseignant.tel_port}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        />
      </div>
      <div className="mb-4">
        <label className="block text-gray-700 font-medium mb-2">Type</label>
        <select
          name="type"
          value={newEnseignant.type}
          onChange={handleInputChange}
          className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
        >
          <option value="ENC">ENC</option>
          <option value="INT">INT</option>
        </select>
      </div>
         {/* Champs spécifiques au type ENC */}
      {newEnseignant.type === "ENC" && (
        <>
          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Téléphone personnel</label>
            <input
              type="text"
              name="enc_perso_tel"
              value={newEnseignant.enc_perso_tel}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Téléphone UBO</label>
            <input
              type="text"
              name="enc_ubo_tel"
              value={newEnseignant.enc_ubo_tel}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Email personnel</label>
            <input
              type="email"
              name="enc_perso_email"
              value={newEnseignant.enc_perso_email}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Email UBO</label>
            <input
              type="email"
              name="enc_ubo_email"
              value={newEnseignant.enc_ubo_email}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>
        </>
      )}

      {/* Champs spécifiques au type INT */}
      {newEnseignant.type === "INT" && (
        <>
          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Numéro INSEE</label>
            <input
              type="text"
              name="int_no_insee"
              value={newEnseignant.int_no_insee}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Nom de la société</label>
            <input
              type="text"
              name="int_soc_nom"
              value={newEnseignant.int_soc_nom}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Adresse de la société</label>
            <input
              type="text"
              name="int_soc_adresse"
              value={newEnseignant.int_soc_adresse}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Code postal de la société</label>
            <input
              type="text"
              name="int_soc_cp"
              value={newEnseignant.int_soc_cp}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Ville de la société</label>
            <input
              type="text"
              name="int_soc_ville"
              value={newEnseignant.int_soc_ville}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Email professionnel</label>
            <input
              type="email"
              name="int_prof_email"
              value={newEnseignant.int_prof_email}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>

          <div className="mb-4">
            <label className="block text-gray-700 font-medium mb-2">Téléphone professionnel</label>
            <input
              type="text"
              name="int_prof_tel"
              value={newEnseignant.int_prof_tel}
              onChange={handleInputChange}
              className="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
            />
          </div>
        </>
      )}
        <div className="flex justify-end">
          <button
            type="button"
            onClick={handleAdd}
            className="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 mr-2"
          >
            Ajouter
          </button>
          <button
            type="button"
            onClick={onClose}
            className="bg-gray-400 text-white px-4 py-2 rounded-lg hover:bg-gray-500"
          >
            Annuler
          </button>
        </div>
      </form>
    </div>
  );
};

export default AddEnseignant;
