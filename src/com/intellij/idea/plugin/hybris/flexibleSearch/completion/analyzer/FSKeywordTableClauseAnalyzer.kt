/*
 * This file is part of "hybris integration" plugin for Intellij IDEA.
 * Copyright (C) 2014-2016 Alexander Bartash <AlexanderBartash@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.intellij.idea.plugin.hybris.flexibleSearch.completion.analyzer

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.idea.plugin.hybris.flexibleSearch.completion.analyzer.checker.FSWhereClauseKeywordsAnalyzer
import com.intellij.idea.plugin.hybris.flexibleSearch.completion.analyzer.checker.FSSelectClauseKeywordsAnalyzer
import com.intellij.idea.plugin.hybris.flexibleSearch.completion.analyzer.checker.FSFromClauseKeywordsAnalyzer
import com.intellij.idea.plugin.hybris.flexibleSearch.completion.provider.FSFieldsCompletionProvider
import com.intellij.idea.plugin.hybris.flexibleSearch.file.FlexibleSearchFile
import com.intellij.idea.plugin.hybris.flexibleSearch.psi.FlexibleSearchJoinCondition
import com.intellij.idea.plugin.hybris.flexibleSearch.psi.FlexibleSearchSelectList
import com.intellij.idea.plugin.hybris.flexibleSearch.psi.FlexibleSearchTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.completion.InsertHandler



/**
 * @author Nosov Aleksandr <nosovae.dev@gmail.com>
 */
object FSKeywordTableClauseAnalyzer {
    private val topLevelKeywords = hashSetOf("SELECT", "FROM", "WHERE", "ORDER", /* Temporarily place this*/ "LEFT", "JOIN", "ON", "BY", "ASC", "DESC")

    fun analyzeKeyword(parameters: CompletionParameters, completionResultSet: CompletionResultSet) {
        if ((parameters.originalPosition == null && !isTableNameIdentifier(parameters) && !isColumnReferenceIdentifier(parameters)) || isFile(parameters)) {
            addToResult(hashSetOf("SELECT", "FROM", "WHERE"), completionResultSet, AllIcons.Nodes.Static, true)
        }
        if ((isColumnReferenceIdentifier(parameters) && parameters.position.skipWhitespaceSiblingsBackward() != null && parameters.position.skipWhitespaceSiblingsBackward()!!.text != "}") ||
                (isColumnReferenceIdentifier(parameters) && PsiTreeUtil.getParentOfType(parameters.position, FlexibleSearchSelectList::class.java) != null)) {
            FSFieldsCompletionProvider.instance.addCompletionVariants(parameters, null, completionResultSet)
        }
        if (isFile(parameters)) {
            addToResult(hashSetOf("SELECT", "FROM", "WHERE"), completionResultSet, AllIcons.Nodes.Static, true)
        }
        
        FSSelectClauseKeywordsAnalyzer.analyzeCompletions(parameters, completionResultSet)
        FSWhereClauseKeywordsAnalyzer.analyzeCompletions(parameters, completionResultSet)
        FSFromClauseKeywordsAnalyzer.analyzeCompletions(parameters, completionResultSet)

    }
}

fun isFile(parameters: CompletionParameters) =
        parameters.position.parent != null && parameters.position.parent.parent != null && parameters.position.parent.parent is FlexibleSearchFile

fun isJoinCondition(parameters: CompletionParameters) =
        parameters.position.parent != null && parameters.position.parent.parent != null && parameters.position.parent.parent is FlexibleSearchJoinCondition

fun isTableNameIdentifier(parameters: CompletionParameters) =
        (parameters.position as LeafPsiElement).elementType == FlexibleSearchTypes.TABLE_NAME_IDENTIFIER

fun isColumnReferenceIdentifier(parameters: CompletionParameters) =
        (parameters.position as LeafPsiElement).elementType == FlexibleSearchTypes.COLUMN_REFERENCE_IDENTIFIER

fun isIdentifier(parameters: CompletionParameters) =
        (parameters.position as LeafPsiElement).elementType == FlexibleSearchTypes.IDENTIFIER


fun addToResult(results: Set<String>, completionResultSet: CompletionResultSet, icon: Icon, bold: Boolean = false) {
    results.forEach { completionResultSet.addElement(LookupElementBuilder.create(it).withCaseSensitivity(false).withBoldness(bold).withIcon(icon)) }
}

fun addSymbolToResult(results: Set<String>, completionResultSet: CompletionResultSet, icon: Icon, bold: Boolean = false) {
    results.forEach { completionResultSet.addElement(LookupElementBuilder.create(it).withPresentableText(it).withCaseSensitivity(false).withBoldness(bold).withIcon(icon)) }
}

fun PsiElement.skipWhitespaceSiblingsBackward() = PsiTreeUtil.skipSiblingsBackward(this, PsiWhiteSpace::class.java)
