/**
 * Twig for Netbeans
 * 
 * Copyright (c) 2011 Sebastian HÃ¶rl
 * 
 * For warranty and licesning information, view the LICENSE file.
 */

package org.netbeans.modules.php.twig.editor.gsf;

import org.netbeans.api.lexer.Language;
import org.netbeans.modules.csl.api.CodeCompletionHandler;
import org.netbeans.modules.csl.api.Formatter;
import org.netbeans.modules.csl.api.StructureScanner;
import org.netbeans.modules.csl.spi.CommentHandler;
import org.netbeans.modules.csl.spi.DefaultLanguageConfig;
import org.netbeans.modules.csl.spi.LanguageRegistration;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.php.twig.editor.completion.TwigCompletionHandler;
import org.netbeans.modules.php.twig.editor.format.TwigFormatter;
import org.netbeans.modules.php.twig.editor.lexer.TwigTopTokenId;
import org.netbeans.modules.php.twig.editor.parsing.TwigParser;

@LanguageRegistration(mimeType="text/twig", useCustomEditorKit=true) //NOI18N
public class TwigLanguage extends DefaultLanguageConfig {
    
    public TwigLanguage() {}

    @Override
    public CommentHandler getCommentHandler() { return null; }

    @Override
    public Language getLexerLanguage() { return TwigTopTokenId.language(); }

    @Override
    public boolean isIdentifierChar(char c) { return Character.isLetter(c); }

    @Override
    public String getDisplayName() { return "Twig"; }
    
    @Override
    public String getPreferredExtension() { return "twig"; }

    // Service registrations
    @Override
    public boolean isUsingCustomEditorKit() { return true; }

    @Override
    public Parser getParser() { return new TwigParser(); }

    @Override
    public boolean hasStructureScanner() { return true; }

    @Override
    public StructureScanner getStructureScanner() { return new TwigStructureScanner(); }

    @Override
    public boolean hasHintsProvider() { return false; }
    
    @Override
    public CodeCompletionHandler getCompletionHandler() {
        return new TwigCompletionHandler();
    }
    
    @Override
    public boolean hasFormatter() {
        return true;
    }

    @Override
    public Formatter getFormatter() {
        return new TwigFormatter();
    }

}